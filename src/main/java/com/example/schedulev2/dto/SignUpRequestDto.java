package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String writer;

    private final String email;

    private final String password;

    public SignUpRequestDto(String writer, String email, String password) {
        this.writer = writer;
        this.email = email;
        this.password = password;
    }
}
