package com.kt.caike.member.db.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "name", "email", "password"})
public class Member {

    private int id;
    private String name;
    private String email;
    private String password;
}
