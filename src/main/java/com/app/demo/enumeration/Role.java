package com.app.demo.enumeration;

import static com.app.demo.constant.Authority.*;

public enum Role {
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    ROLE_USER(USER_AUTHORITIES),
    ROLE_OPERATOR_BARRAGE(MANAGER_AUTHORITIES),
    ROLE_OPERATOR_BAC(ADMIN_AUTHORITIES);


    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
