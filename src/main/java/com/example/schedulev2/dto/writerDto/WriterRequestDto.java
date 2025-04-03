package com.example.schedulev2.dto.writerDto;

import lombok.Getter;

@Getter
public class WriterRequestDto {

    private final String writer;

    private final String email;

    private final String password;

    public WriterRequestDto(String writer, String email, String password) {
        this.writer = writer;
        this.email = email;
        this.password = password;
    }
}
