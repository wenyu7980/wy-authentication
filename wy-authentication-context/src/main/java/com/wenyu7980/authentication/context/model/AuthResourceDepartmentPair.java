package com.wenyu7980.authentication.context.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wenyu
 */
public class AuthResourceDepartmentPair {
    /** 资源id */
    private Set<String> resources;
    /** 部门id */
    private Set<String> departments;

    public AuthResourceDepartmentPair(String resource, Collection<String> departments) {
        this.resources = new HashSet<>();
        this.resources.add(resource);
        this.departments = new HashSet<>(departments);
    }

    public void addResource(String resourceId) {
        this.resources.add(resourceId);
    }

    public Set<String> getResources() {
        return Collections.unmodifiableSet(resources);
    }

    public Set<String> getDepartments() {
        return Collections.unmodifiableSet(departments);
    }
}
