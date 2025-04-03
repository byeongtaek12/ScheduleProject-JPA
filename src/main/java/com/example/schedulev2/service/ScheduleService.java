package com.example.schedulev2.service;

import com.example.schedulev2.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto save(Long writer_id, String title, String contents);

    List<ScheduleResponseDto> findAllSchedule(Long writer_id);

    ScheduleResponseDto findScheduleById(Long writer_id, Long id);

    ScheduleResponseDto updateSchedule(Long writer_id, Long id);

    void deleteSchedule(Long writer_id, Long id);
}