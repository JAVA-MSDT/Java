package com.javamsdt.classes.enums;

public enum ErrorCode {
    INVALID_INPUT(1001),
    DATABASE_ERROR(2001),
    NETWORK_ERROR(3001),
    PERMISSION_DENIED(4001),
    DEFAULT_ERROR(4004);

    private final int code;

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

