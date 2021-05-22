package com.wenyu7980.authentication.context.model;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class AuthResource {
    /** 类型 */
    private String type;
    /** id */
    private String id;

    private AuthResource() {
    }

    public AuthResource(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthResource that = (AuthResource) o;
        return Objects.equals(type, that.type) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
