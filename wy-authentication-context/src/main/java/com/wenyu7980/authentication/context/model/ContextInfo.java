package com.wenyu7980.authentication.context.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
public class ContextInfo {
    /** 用户id */
    private String userId;
    /** 部门id */
    private String departmentId;
    /** 系统管理员标志 */
    private Boolean systemFlag;
    /** 请求 */
    private Request request;
    /** matrix权限 */
    private Collection<AuthenticationRolePermission> permissions = new ArrayList<>();
    /** code */
    transient private Map<String, Set<String>> codes = new HashMap<>();
    /** 权限-部门 */
    transient private Map<AuthPermission, Set<String>> permissionDepartments = new HashMap<>();
    /** 权限-资源-部门 */
    transient private Map<AuthPermission, Map<String, List<AuthResourcePair>>> resourceDepartments = new HashMap<>();

    public ContextInfo() {
    }

    public ContextInfo(String userId) {
        this.userId = userId;
    }

    public ContextInfo(Request request) {
        this.systemFlag = false;
        this.request = request;
    }

    public ContextInfo(String userId, String departmentId, Boolean systemFlag,
      Collection<AuthenticationRolePermission> permissions, Request request) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.systemFlag = systemFlag;
        this.request = request;
        this.permissions = permissions;
    }

    public void init() {
        // 接口-resource-resourceId-departments
        final Map<AuthPermission, Map<String, Map<String, Set<String>>>> resources = new HashMap<>();
        for (AuthenticationRolePermission rolePermission : permissions) {
            AuthPermission permission = AuthPermission
              .of(rolePermission.getServiceName(), rolePermission.getMethod(), rolePermission.getPath());
            if (rolePermission.getResource() == null) {
                if (!this.permissionDepartments.containsKey(permission)) {
                    this.permissionDepartments.put(permission, new HashSet<>());
                }
                this.permissionDepartments.get(permission).add(rolePermission.getDepartmentId());
            } else {
                if (!resources.containsKey(permission)) {
                    resources.put(permission, new HashMap<>());
                }
                if (!resources.get(permission).containsKey(rolePermission.getResource())) {
                    resources.get(permission).put(rolePermission.getResource(), new HashMap<>());
                }
                if (!resources.get(permission).get(rolePermission.getResource())
                  .containsKey(rolePermission.getResourceId())) {
                    resources.get(permission).get(rolePermission.getResource())
                      .put(rolePermission.getResourceId(), new HashSet<>());
                }
                resources.get(permission).get(rolePermission.getResource()).get(rolePermission.getResourceId())
                  .add(rolePermission.getDepartmentId());
            }
            if (rolePermission.getCode() != null) {
                if (!this.codes.containsKey(rolePermission.getCode())) {
                    this.codes.put(rolePermission.getCode(), new HashSet<>());
                }
                this.codes.get(rolePermission.getCode()).add(rolePermission.getDepartmentId());
            }
        }
        for (Map.Entry<AuthPermission, Map<String, Map<String, Set<String>>>> permission : resources.entrySet()) {
            if (!this.resourceDepartments.containsKey(permission.getKey())) {
                this.resourceDepartments.put(permission.getKey(), new HashMap<>());
            }
            RESOURCE:
            for (Map.Entry<String, Map<String, Set<String>>> resource : permission.getValue().entrySet()) {
                if (!this.resourceDepartments.get(permission.getKey()).containsKey(resource.getKey())) {
                    this.resourceDepartments.get(permission.getKey()).put(resource.getKey(), new ArrayList<>());
                }
                for (Map.Entry<String, Set<String>> department : resource.getValue().entrySet()) {
                    for (AuthResourcePair pair : this.resourceDepartments.get(permission.getKey())
                      .get(resource.getKey())) {
                        if (department.getValue().containsAll(pair.getDepartments()) && pair.getDepartments()
                          .containsAll(department.getValue())) {
                            pair.addResourceId(department.getKey());
                            continue RESOURCE;
                        }
                    }
                    this.resourceDepartments.get(permission.getKey()).get(resource.getKey())
                      .add(new AuthResourcePair(department.getKey(), department.getValue()));
                }
            }
        }
    }

    public Set<String> getDepartments() {
        return Collections.unmodifiableSet(this.getPermissionDepartments().getOrDefault(this.request, new HashSet<>()));
    }

    public List<AuthResourcePair> getDepartmentPairs(String resource) {
        return Collections.unmodifiableList(this.resourceDepartments.getOrDefault(this.request, new HashMap<>())
          .getOrDefault(resource, new ArrayList<>()));
    }

    public Set<String> getDepartments(String resource, String value) {
        Map<String, List<AuthResourcePair>> resources = this.resourceDepartments.get(this.request);
        if (resources != null) {
            List<AuthResourcePair> pairs = resources.get(resource);
            if (pairs != null) {
                return pairs.stream().filter(p -> p.getResources().contains(value))
                  .flatMap(p -> p.getDepartments().stream()).collect(Collectors.toSet());
            }
        }
        return new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public Request getRequest() {
        return request;
    }

    public Collection<AuthenticationRolePermission> getPermissions() {
        return permissions;
    }

    public Map<AuthPermission, Set<String>> getPermissionDepartments() {
        return permissionDepartments;
    }

    public Boolean getSystemFlag() {
        return systemFlag;
    }

}
