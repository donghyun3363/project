package com.kt.caike.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberStatus {
    ENABLE(0, "사용"),
    UNABLE(1, "미사용"),
    SUSPEND(2, "중지"),
    ;

    private int number;
    private String description;
}
