package com.hyun.project.advice;

public enum ErrorCode {

    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    MEMBER_NOT_EXIST(410, "C001", "MEMBER Is Not Exist");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
