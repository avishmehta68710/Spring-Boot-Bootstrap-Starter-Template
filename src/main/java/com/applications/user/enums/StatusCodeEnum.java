package com.applications.user.enums;

public enum StatusCodeEnum {
    SUCCESS(6000),
    BAD_REQUEST(6400),
    FORBIDDEN(6403),
    UNAUTHORIZED(6404),
    INTERNAL_SERVER_ERROR(6500)
    ;

    private final int statusCodeValue;
    StatusCodeEnum(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    public Integer statusCodeValue() {
        return statusCodeValue;
    }
}