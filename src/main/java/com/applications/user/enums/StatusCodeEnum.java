package com.applications.user.enums;

public enum StatusCodeEnum {
    SUCCESS(2000),
    BAD_REQUEST(4400),
    FORBIDDEN(4403),
    UNAUTHORIZED(4404),
    INTERNAL_SERVER_ERROR(5000)
    ;

    private final int statusCodeValue;
    StatusCodeEnum(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    public Integer statusCodeValue() {
        return statusCodeValue;
    }
}