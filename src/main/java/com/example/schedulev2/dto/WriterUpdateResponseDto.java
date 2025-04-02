package com.example.schedulev2.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WriterUpdateResponseDto {

    private final Long id;

    private final String writer;

    private final String email;

    private final String password;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;


    public WriterUpdateResponseDto(Long id, String writer, String email, String password, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

