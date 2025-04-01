package com.example.schedulev2.dto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleResponseDto {

    private Long id;

    private Long writer_id;

    private String title;

    private String contents;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, Long writer_id, String title, String contents, LocalDateTime createdAt,
                               LocalDateTime modifiedAt) {
        this.id=id;
        this.writer_id = writer_id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
