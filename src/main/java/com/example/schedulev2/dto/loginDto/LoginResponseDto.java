package com.example.schedulev2.dto.loginDto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final Long id;

    private final String writer;


    public LoginResponseDto(Long id, String writer) {
        this.id = id;
        this.writer = writer;
    }
}

