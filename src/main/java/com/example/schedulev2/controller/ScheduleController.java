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

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody CreateScheduleRequestDto requestDto,
                                                            HttpServletRequest httpServletRequest) {

        ScheduleResponseDto savedSchedule = scheduleService.save(getSessionKey(httpServletRequest), requestDto.getTitle(),
                requestDto.getContents());

        return new ResponseEntity<>(savedSchedule,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(HttpServletRequest httpServletRequest) {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAllSchedule(
                getSessionKey(httpServletRequest));

        return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id,
                                                                HttpServletRequest httpServletRequest) {

        ScheduleResponseDto findSchedule = scheduleService.findScheduleById(getSessionKey(httpServletRequest),id);

        return new ResponseEntity<>(findSchedule, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,
                                                              HttpServletRequest httpServletRequest) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(getSessionKey(httpServletRequest), id);

        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, HttpServletRequest httpServletRequest) {

        scheduleService.deleteSchedule(getSessionKey(httpServletRequest),id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    private Long getSessionKey(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        return (Long) session.getAttribute("sessionKey");
    }

}
