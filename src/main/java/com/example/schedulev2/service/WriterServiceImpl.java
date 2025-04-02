package com.example.schedulev2.service;

import com.example.schedulev2.dto.LoginResponseDto;
import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.dto.WriterUpdateResponseDto;
import com.example.schedulev2.entity.Writer;
import com.example.schedulev2.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService{
    private final WriterRepository writerRepository;

    @Override
    public LoginResponseDto signUp(String writer, String email, String password) {

        Writer writer1 = new Writer(writer, email, password);

        Writer savedWriter = writerRepository.save(writer1);

        return new LoginResponseDto(savedWriter.getId(),savedWriter.getWriter());
    }

    @Override
    public LoginResponseDto login(String email, String password) {

        Writer findWriter = writerRepository.findWriterByEmailAndPasswordOrElseThrow(email, password);

        return new LoginResponseDto(findWriter.getId(),findWriter.getWriter());
    }

    @Override
    public List<WriterResponseDto> findAll() {

        return writerRepository.findAll().stream().map(WriterResponseDto::new).toList();

    }

    @Override
    public WriterResponseDto findById(Long id) {

        Writer findWriter = writerRepository.findByIdOrElseThrow(id);

        return new WriterResponseDto(findWriter.getId(),findWriter.getWriter(),findWriter.getCreatedAt(),
                findWriter.getModifiedAt());
    }

    @Override
    public WriterUpdateResponseDto updateWriter(Long id, WriterRequestDto writerRequestDto) {

        Writer findWriter = writerRepository.findByIdOrElseThrow(id);

        if (writerRequestDto.getWriter()!=null) {
            findWriter.setWriter(writerRequestDto.getWriter());
        }

        if (writerRequestDto.getEmail()!=null) {
            findWriter.setEmail(writerRequestDto.getEmail());
        }

        if (writerRequestDto.getPassword()!=null) {
            findWriter.setPassword(writerRequestDto.getPassword());
        }

        writerRepository.save(findWriter);

        return new WriterUpdateResponseDto(findWriter.getId(),findWriter.getWriter(),findWriter.getEmail(),
                findWriter.getPassword(),findWriter.getCreatedAt(),LocalDateTime.now());

    }

    @Override
    public void delete(Long id) {

        Writer findWriter = writerRepository.findByIdOrElseThrow(id);

        writerRepository.delete(findWriter);
    }




}
