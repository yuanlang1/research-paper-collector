package com.yl.paperservice.result;

import org.springframework.data.relational.core.sql.In;

public enum ResponseCode {
    SUCCESS(0, "success"),
    BUSINESS_ERROR(1, "business error"),
    UNAUTHORIZED(2, "unauthorized"),
    FORBIDDEN(3, "forbidden"),
    SERVER_ERROR(500, "server error");

    public final Integer code;
    public final String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
