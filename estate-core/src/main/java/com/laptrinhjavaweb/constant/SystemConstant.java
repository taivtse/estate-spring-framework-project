package com.laptrinhjavaweb.constant;

public class SystemConstant {
    public static final boolean USER_ACTIVE = true;
    public static final boolean USER_UNACTIVE = false;
    public static final String ROLE_STAFF = "STAFF";
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String COMMAND = "command";

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 3600000;//1h
    public static final String SIGNING_KEY = "laptrinhjavaweb";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
}
