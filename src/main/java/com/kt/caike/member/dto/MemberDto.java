package com.kt.caike.member.dto;

import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@ToString
public class MemberDto {

    private int id;

    @ApiParam(value = "member ID", required = true)
    @NotBlank(message = "이름은 필수 값입니다.")
    private String name;

    @ApiParam(value = "member Email", required = true)
    @NotBlank(message = "이메일은 필수 값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @ApiParam(value = "member Password", required = true)
    @NotBlank(message = "패스워드는 필수 값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n"
            , message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @Builder
    private MemberDto(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

/*
Vaildation annotation

@Null  // null만 혀용합니다.
@NotNull  // null을 허용하지 않습니다. "", " "는 허용합니다.
@NotEmpty  // null, ""을 허용하지 않습니다. " "는 허용합니다.
@NotBlank  // null, "", " " 모두 허용하지 않습니다.

@Email  // 이메일 형식을 검사합니다. 다만 ""의 경우를 통과 시킵니다. @Email 보다 아래 나올 @Patten을 통한 정규식 검사를 더 많이 사용합니다.
@Pattern(regexp = )  // 정규식을 검사할 때 사용됩니다.
@Size(min=, max=)  // 길이를 제한할 때 사용됩니다.

@Max(value = )  // value 이하의 값을 받을 때 사용됩니다.
@Min(value = )  // value 이상의 값을 받을 때 사용됩니다.

@Positive  // 값을 양수로 제한합니다.
@PositiveOrZero  // 값을 양수와 0만 가능하도록 제한합니다.

@Negative  // 값을 음수로 제한합니다.
@NegativeOrZero  // 값을 음수와 0만 가능하도록 제한합니다.

@Future  // 현재보다 미래
@Past  // 현재보다 과거

@AssertFalse  // false 여부, null은 체크하지 않습니다.
@AssertTrue  // true 여부, null은 체크하지 않습니다.
*/