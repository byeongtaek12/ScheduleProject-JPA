package com.example.schedulev2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String writer;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public SignUpResponseDto(Long id, String writer, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
