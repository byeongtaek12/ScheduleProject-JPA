package com.example.schedulev2.service.scheduleService;

import com.example.schedulev2.dto.scheduleDto.ScheduleResponseDto;
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
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final WriterRepository writerRepository;

    // service) 일정 저장 메서드
    @Override
    public ScheduleResponseDto saveSchedule(Long writer_id, String title, String contents) {

        Writer findWriter = writerRepository.findById(writer_id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Does not exist writer_id: " + writer_id));

        Schedulev2 schedulev2 = new Schedulev2(findWriter, title, contents);

        Schedulev2 savedSchedule = scheduleRepository.save(schedulev2);

        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getWriter().getId(),
                savedSchedule.getTitle(),savedSchedule.getContents(), LocalDateTime.now(),LocalDateTime.now());
    }

    // service) 모든 일정 조회 메서드
    @Override
    public List<ScheduleResponseDto> findAllSchedule(Long writer_id) {

        checkSessionKey(writer_id);

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
                                                  //.map(a-> new ScheduleResponseDto(a))과 같음
    }

    // service) 일정 조회 메서드
    @Override
    public ScheduleResponseDto findScheduleById(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        return new ScheduleResponseDto(findScheduleById(id));

    }

    // service) 일정 수정 메서드
    @Override
    public ScheduleResponseDto updateSchedule(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        Schedulev2 updateSchedule = scheduleRepository.save(findScheduleById(id));

        return new ScheduleResponseDto(updateSchedule);

    }

    // service) 일정 삭제 메서드
    @Override
    public void deleteSchedule(Long writer_id, Long id) {

        checkSessionKey(writer_id);

        scheduleRepository.delete(findScheduleById(id));

    }

    // 세션키가 있는지 체크하는 메서드
    private void checkSessionKey(Long writer_id) {
        if (writer_id==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"로그인부터 해주세요");
        }
    }

    // 아이디값을 받아 그 값의 일정이 존재하는지 찾는 메서드
    private Schedulev2 findScheduleById(Long id) {

        return scheduleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Does not exist id: " + id));

    }
}
