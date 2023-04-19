package com.lew.eventtimeline.common.security;


import static com.lew.eventtimeline.common.security.Authority.ADMIN_AUTHORITIES;

public enum Role {
    ROLE_ADMIN(ADMIN_AUTHORITIES);

    private final String[] authorities;

    Role(String... userAuthorities) {
        this.authorities = userAuthorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
