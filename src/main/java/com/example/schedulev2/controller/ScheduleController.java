package com.example.schedulev2.controller;

import com.example.schedulev2.dto.CreateScheduleRequestDto;
import com.example.schedulev2.dto.ScheduleResponseDto;
import com.example.schedulev2.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody CreateScheduleRequestDto requestDto,
                                                            HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Long writer_id = (Long) session.getAttribute("sessionKey");

        ScheduleResponseDto savedSchedule = scheduleService.save(writer_id, requestDto.getTitle(),
                requestDto.getContents());

        return new ResponseEntity<>(savedSchedule,HttpStatus.CREATED);
    }

}
