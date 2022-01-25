package com.kt.caike.common.exception;

import com.kt.caike.common.type.ErrorCode;

public class MemberNotExistException extends CustomException {

    private static final long serialVersionUID = -2116671122895194101L;

    public MemberNotExistException() {
        super(ErrorCode.MEMBER_NOT_EXIST);
    }
}
