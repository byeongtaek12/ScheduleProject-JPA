package com.example.schedulev2.service.writerService;

import com.example.schedulev2.dto.LoginResponseDto;
import com.example.schedulev2.dto.writerDto.WriterRequestDto;
import com.example.schedulev2.dto.writerDto.WriterResponseDto;
import com.example.schedulev2.dto.writerDto.WriterUpdateResponseDto;
import com.example.schedulev2.entity.Writer;
import com.example.schedulev2.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService {
    private final WriterRepository writerRepository;


    // writerService) 회원가입 메서드
    @Override
    public LoginResponseDto signUp(String writer, String email, String password) {

        Writer writer1 = new Writer(writer, email, password);

        Writer savedWriter = writerRepository.save(writer1);

        return new LoginResponseDto(savedWriter.getId(),savedWriter.getWriter());
    }

    // writerService) 로그인 메서드
    @Override
    public LoginResponseDto login(String email, String password) {

        Writer findWriter = writerRepository.findWriterByEmailAndPassword(email,password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                        "이메일이나 패스워드가 틀려서 로그인 실패했습니다."));

        return new LoginResponseDto(findWriter.getId(),findWriter.getWriter());
    }

    // writerService) 모든 유저 조회 메서드
    @Override
    public List<WriterResponseDto> findAllWriter(Long writer_id) {

        checkSessionKey(writer_id);

        return writerRepository.findAll().stream().map(WriterResponseDto::new).toList();

    }

    // writerService) 유저 조회 메서드
    @Override
    public WriterResponseDto findWriterById(Long writer_id,Long id) {

        checkSessionKey(writer_id);

        return new WriterResponseDto(findWriter(id).getId(),findWriter(id).getWriter(),findWriter(id).getCreatedAt(),
                findWriter(id).getModifiedAt());

    }

    // writerService) 유저 수정 메서드
    @Override
    public WriterUpdateResponseDto updateWriter(Long writer_id,Long id, WriterRequestDto writerRequestDto) {

        checkSessionKey(writer_id);

        Writer findWriter = findWriter(id);

        notNullSetWriter(writerRequestDto,findWriter);

        writerRepository.save(findWriter);

        return new WriterUpdateResponseDto(findWriter.getId(),findWriter.getWriter(),findWriter.getEmail(),
                findWriter.getPassword(),findWriter.getCreatedAt(),LocalDateTime.now());

    }

    // writerService) 유저 삭제 메서드
    @Override
    public void deleteWriter(Long writer_id,Long id) {

        checkSessionKey(writer_id);

        writerRepository.delete(findWriter(id));

    }

    // 세션키가 있는지 체크하는 메서드
    private void checkSessionKey(Long writer_id) {

        if (writer_id==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"로그인부터 해주세요");
        }

    }

    // 아이디값을 받아 그 값의 유저가 존재하는지 확인하는 메서드
    private Writer findWriter(Long id) {

        return writerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Does not exist id: " + id));

    }

    // 널이 아닌 값을 수정해주는 메서드
    private void notNullSetWriter(WriterRequestDto writerRequestDto, Writer findWriter) {
        if (writerRequestDto.getWriter()!=null) {
            findWriter.setWriter(writerRequestDto.getWriter());
        }

        if (writerRequestDto.getEmail()!=null) {
            findWriter.setEmail(writerRequestDto.getEmail());
        }

        if (writerRequestDto.getPassword()!=null) {
            findWriter.setPassword(writerRequestDto.getPassword());
        }
    }
}
