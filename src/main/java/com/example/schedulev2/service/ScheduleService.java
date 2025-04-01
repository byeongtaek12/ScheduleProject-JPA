package com.example.schedulev2.service;

import com.example.schedulev2.dto.ScheduleResponseDto;

public interface ScheduleService {
    ScheduleResponseDto save(Long writer_id, String title, String contents);
}