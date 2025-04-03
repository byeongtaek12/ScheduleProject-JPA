package com.example.schedulev2.dto.loginDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginReqeustDto {

    @NotBlank(message = "유저명을 입력하세요.")
    private final String writer;

    @NotBlank(message = "이메일을 입력하세요.")
    @Pattern(
            regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "올바른 이메일 형식을 입력하세요."
    )
    private final String email;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private final String password;

    public LoginReqeustDto(String writer, String email, String password) {
        this.writer = writer;
        this.email = email;
        this.password = password;
    }
}
