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
    /** 请求 */
    private Request request;
    /** matrix权限 */
    private Set<AuthenticationMatrix> matrices = new HashSet<>();
    /** 权限-部门 */
    transient private Map<AuthPermission, Set<String>> permissionDepartments = new HashMap<>();
    /** 权限-资源-部门 */
    transient private Map<AuthPermission, Map<String, List<AuthResourceDepartmentPair>>> permissionResourceDepartments = new HashMap<>();

    public ContextInfo() {
    }

    public ContextInfo(String userId) {
        this.userId = userId;
    }

    public ContextInfo(String userId, Set<AuthenticationMatrix> matrices, Request request) {
        this.userId = userId;
        this.request = request;
        this.setMatrices(matrices);
    }

    public Set<String> getDepartments() {
        return Collections.unmodifiableSet(this.getPermissionDepartments().get(this.request));
    }

    public Set<String> getDepartments(String code, String value) {
        return Collections.unmodifiableSet(this.getPermissionResourceDepartments().get(this.request).get(code).stream()
          .filter(a -> a.getResources().contains(value)).flatMap(a -> a.getDepartments().stream())
          .collect(Collectors.toSet()));
    }

    public String getUserId() {
        return userId;
    }

    public Request getRequest() {
        return request;
    }

    public Set<AuthenticationMatrix> getMatrices() {
        return matrices;
    }

    public Map<AuthPermission, Set<String>> getPermissionDepartments() {
        return permissionDepartments;
    }

    public Map<AuthPermission, Map<String, List<AuthResourceDepartmentPair>>> getPermissionResourceDepartments() {
        return permissionResourceDepartments;
    }

    private void setMatrices(Set<AuthenticationMatrix> matrices) {
        this.matrices = matrices;
        OUT:
        for (AuthenticationMatrix matrix : matrices) {
            if (matrix.getAuthResource() == null) {
                if (!this.permissionDepartments.containsKey(matrix.getPermission())) {
                    this.permissionDepartments.put(matrix.getPermission(), new HashSet<>());
                }
                this.permissionDepartments.get(matrix.getPermission()).addAll(matrix.getDepartments());
            } else {
                if (!this.permissionResourceDepartments.containsKey(matrix.getPermission())) {
                    this.permissionResourceDepartments.put(matrix.getPermission(), new HashMap<>());
                }
                if (!this.permissionResourceDepartments.get(matrix.getPermission())
                  .containsKey(matrix.getAuthResource().getType())) {
                    this.permissionResourceDepartments.get(matrix.getPermission())
                      .put(matrix.getAuthResource().getType(), new ArrayList<>());
                }
                List<AuthResourceDepartmentPair> authResourceDepartmentPairs = this.permissionResourceDepartments
                  .get(matrix.getPermission()).get(matrix.getAuthResource().getType());
                for (AuthResourceDepartmentPair pair : authResourceDepartmentPairs) {
                    if (pair.getDepartments().containsAll(matrix.getDepartments()) && matrix.getDepartments()
                      .containsAll(pair.getDepartments())) {
                        pair.addResource(matrix.getAuthResource().getId());
                        continue OUT;
                    }
                }
                authResourceDepartmentPairs
                  .add(new AuthResourceDepartmentPair(matrix.getAuthResource().getId(), matrix.getDepartments()));
            }
        }
    }

}
