package com.example.schedulev2.dto;

import com.example.schedulev2.entity.Writer;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WriterResponseDto {

    private final Long id;

    private final String writer;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public WriterResponseDto(Long id, String writer, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public WriterResponseDto(Writer writer) {
        this(writer.getId(),writer.getWriter(), writer.getCreatedAt(),writer.getModifiedAt());
    }
}
