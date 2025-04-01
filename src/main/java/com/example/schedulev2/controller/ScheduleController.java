package com.example.schedulev2.controller;

import com.example.schedulev2.dto.CreateScheduleRequestDto;
import com.example.schedulev2.dto.ScheduleResponseDto;
import com.example.schedulev2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{writer_id}")
    public ResponseEntity<ScheduleResponseDto> saveSchedule(
            @PathVariable Long writer_id,
            @RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto savedSchedule = scheduleService.save(writer_id, requestDto.getTitle(),
                requestDto.getContents());

        return new ResponseEntity<>(savedSchedule,HttpStatus.CREATED);
    }

}
