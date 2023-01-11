package com.applications.user.controllers;

public class Endpoints {
    public static class UserAPI{
        public static final String BASE_URL = "/api/v1/user";
        public static final String USER = "/";
        public static final String UPDATE_USER = "/update";
        public static final String DELETE_USER_BY_EMAIL = "/delete";
        public static final String ADD_USER = "/add";
        public static final String USER_BY_EMAIL = "/search";

    }
    public static class HealthAPI{
        public static final String BASE_URL = "/api/v1/health";
        public static final String HEALTH = "/";
    }

}
