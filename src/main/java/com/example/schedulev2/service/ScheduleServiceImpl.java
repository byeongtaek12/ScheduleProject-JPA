package com.example.schedulev2.service;

import com.example.schedulev2.dto.ScheduleResponseDto;
import com.example.schedulev2.entity.Schedulev2;
import com.example.schedulev2.entity.Writer;
import com.example.schedulev2.repository.ScheduleRepository;
import com.example.schedulev2.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;
    private final WriterRepository writerRepository;

    @Override
    public ScheduleResponseDto save(Long writer_id, String title, String contents) {

        Writer findWriter = writerRepository.findByIdOrElseThrow(writer_id);

        Schedulev2 schedulev2 = new Schedulev2(findWriter, title, contents);

        Schedulev2 savedSchedule = scheduleRepository.save(schedulev2);

        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getWriter().getId(),
                savedSchedule.getTitle(),savedSchedule.getContents(), LocalDateTime.now(),LocalDateTime.now());
    }
}
