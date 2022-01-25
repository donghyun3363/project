package com.kt.caike.common.exception;

import com.kt.caike.common.type.ErrorCode;

public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
