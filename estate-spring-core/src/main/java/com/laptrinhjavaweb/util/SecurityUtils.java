package com.laptrinhjavaweb.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {
    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        SecurityUtils.getAuthentication().getAuthorities()
                .forEach(authority -> results.add(authority.getAuthority()));
        return results;
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
