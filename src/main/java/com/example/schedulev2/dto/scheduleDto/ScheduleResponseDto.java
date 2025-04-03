package com.example.schedulev2.dto.scheduleDto;

import com.example.schedulev2.entity.Schedulev2;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final Long writer_id;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, Long writer_id, String title, String contents, LocalDateTime createdAt,
                               LocalDateTime modifiedAt) {
        this.id=id;
        this.writer_id = writer_id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ScheduleResponseDto(Schedulev2 schedulev2) {

        this(schedulev2.getId(),schedulev2.getWriter().getId(),schedulev2.getTitle(), schedulev2.getContents(),
                schedulev2.getCreatedAt(),schedulev2.getModifiedAt());

    }
}
