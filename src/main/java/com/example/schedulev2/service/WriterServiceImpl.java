package com.example.schedulev2.service;

import com.example.schedulev2.dto.WriterResponseDto;
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
    public WriterResponseDto signUp(String writer, String email, String password) {

        Writer writer1 = new Writer(writer, email, password);

        Writer savedWriter = writerRepository.save(writer1);

        return new WriterResponseDto(savedWriter.getId(),savedWriter.getWriter(), LocalDateTime.now(),
                LocalDateTime.now());
    }

    @Override
    public List<WriterResponseDto> findAll() {

        return writerRepository.findAll().stream().map(WriterResponseDto::new).toList();

    }
}
