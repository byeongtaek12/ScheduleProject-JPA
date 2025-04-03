package com.example.schedulev2.service.writerService;

import com.example.schedulev2.dto.loginDto.LoginResponseDto;
import com.example.schedulev2.dto.writerDto.WriterRequestDto;
import com.example.schedulev2.dto.writerDto.WriterResponseDto;
import com.example.schedulev2.dto.writerDto.WriterUpdateResponseDto;

import java.util.List;

public interface WriterService {
    LoginResponseDto signUp(String writer, String email, String password);

    LoginResponseDto login(String email, String password);

    List<WriterResponseDto> findAllWriter(Long writer_id);

    WriterResponseDto findWriterById(Long writer_id,Long id);

    WriterUpdateResponseDto updateWriter(Long writer_id,Long id, WriterRequestDto writerRequestDto);

    void deleteWriter(Long writer_id,Long id);
}
