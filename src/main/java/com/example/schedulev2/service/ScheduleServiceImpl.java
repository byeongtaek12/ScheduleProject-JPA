package com.example.schedulev2.service;

import com.example.schedulev2.dto.ScheduleResponseDto;
import com.example.schedulev2.entity.Schedulev2;
import com.example.schedulev2.entity.Writer;
import com.example.schedulev2.repository.ScheduleRepository;
import com.example.schedulev2.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;
    private final WriterRepository writerRepository;

    @Override
    public ScheduleResponseDto saveSchedule(Long writer_id, String title, String contents) {

        Writer findWriter = writerRepository.findByIdOrElseThrow(writer_id);

        Schedulev2 schedulev2 = new Schedulev2(findWriter, title, contents);

        Schedulev2 savedSchedule = scheduleRepository.save(schedulev2);

        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getWriter().getId(),
                savedSchedule.getTitle(),savedSchedule.getContents(), LocalDateTime.now(),LocalDateTime.now());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule(Long writer_id) {

        checkSessionKey(writer_id);

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
                                                  //.map(a-> new ScheduleResponseDto(a))과 같음
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        return new ScheduleResponseDto(findScheduleById(id));

    }

    @Override
    public ScheduleResponseDto updateSchedule(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        Schedulev2 updateSchedule = scheduleRepository.save(findScheduleById(id));

        return new ScheduleResponseDto(updateSchedule);

    }

    @Override
    public void deleteSchedule(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        scheduleRepository.delete(findScheduleById(id));

    }

    private void checkSessionKey(Long writer_id) {
        if (writer_id==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"로그인부터 해주세요");
        }
    }

    private Schedulev2 findScheduleById(Long id) {

        return scheduleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Does not exist id: " + id));

    }
}
