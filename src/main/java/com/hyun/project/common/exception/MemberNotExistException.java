package com.hyun.project.common.exception;

import com.hyun.project.common.type.ErrorCode;

public class MemberNotExistException extends CustomException {

    private static final long serialVersionUID = -2116671122895194101L;

    public MemberNotExistException() {
        super(ErrorCode.MEMBER_NOT_EXIST);
    }
}
