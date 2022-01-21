package com.hyun.project.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

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
