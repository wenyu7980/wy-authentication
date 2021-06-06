package com.wenyu7980.auth.query;

import com.wenyu7980.auth.data.annotation.AuthData;
import com.wenyu7980.auth.data.annotation.AuthMeta;
import com.wenyu7980.auth.data.annotation.AuthResource;
import com.wenyu7980.auth.data.constant.AuthType;
import com.wenyu7980.authentication.context.model.AuthResourcePair;
import com.wenyu7980.authentication.context.model.ContextInfo;
import com.wenyu7980.authentication.context.model.ContextUtils;
import com.wenyu7980.common.exceptions.code500.SystemException;
import com.wenyu7980.query.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 查询utils
 */
public class AuthQueryUtils {
    private AuthQueryUtils() {
    }

    public static QueryLogic restraint(Class clazz) {
        if (!ContextUtils.isPresent() || ContextUtils.get().getSystemFlag()) {
            return QueryLogic.and();
        }
        ContextInfo context = ContextUtils.get();
        List<FieldResource> resources = new ArrayList<>();
        List<String> departmentFields = new ArrayList<>();
        List<QueryPredicateExpress> expresses = new ArrayList<>();
        Set<String> departments = context.getDepartments();
        for (Field field : clazz.getDeclaredFields()) {
            AuthResource resource = field.getAnnotation(AuthResource.class);
            if (resource != null) {
                resources.add(new FieldResource(field.getName(), resource.value()));
                continue;
            }
            AuthMeta meta = field.getAnnotation(AuthMeta.class);
            if (meta != null) {
                if (meta.value() == AuthType.U) {
                    expresses.add(QueryCondition.of(field.getName(), QueryCompare.EQ, context.getUserId()));
                } else {
                    if (departments.size() > 0) {
                        expresses.add(QueryCondition.of(field.getName(), QueryCompare.IN, departments));
                    }
                    departmentFields.add(field.getName());
                }
                continue;
            }
            AuthData data = field.getAnnotation(AuthData.class);
            if (data != null) {
                if (Collection.class.isAssignableFrom(field.getType())) {
                    ParameterizedType type = (ParameterizedType) field.getGenericType();
                    Class typeArgument = (Class) type.getActualTypeArguments()[0];
                    expresses.add(QueryExists.exists(typeArgument,
                      (f1, f2, b) -> b.equal(f1.get(field.getName()), f2.get(getIdName(typeArgument))),
                      restraint(typeArgument)));
                } else {
                    expresses.add(QueryJoin.join(field.getName(), restraint(field.getType())));
                }
                continue;
            }
        }
        if (departments.size() > 0) {
            for (String field : departmentFields) {
                expresses.add(QueryCondition.of(field, QueryCompare.IN, departments));
            }
        }
        for (FieldResource resource : resources) {
            List<AuthResourcePair> departmentPairs = context.getDepartmentPairs(resource.resource);
            if (departmentPairs.size() == 0) {
                continue;
            }
            for (AuthResourcePair pair : departmentPairs) {
                for (String department : departmentFields) {
                    expresses.add(QueryLogic.and(QueryCondition.of(resource.name, QueryCompare.IN, pair.getResources()),
                      QueryCondition.of(department, QueryCompare.IN, pair.getDepartments())));
                }
            }
        }

        return QueryLogic.or(expresses);
    }

    private static class FieldResource {
        private String name;
        private String resource;

        public FieldResource(String name, String resource) {
            this.name = name;
            this.resource = resource;
        }
    }

    private static String getIdName(Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (null != field.getAnnotation(Id.class)) {
                return field.getName();
            }
            if (null != field.getAnnotation(EmbeddedId.class)) {
                return field.getName();
            }
        }
        throw new SystemException("{0}没有@Id注解的主KEY", clazz);
    }
}
