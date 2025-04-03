package com.example.schedulev2.service;

import com.example.schedulev2.dto.LoginResponseDto;
import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.dto.WriterUpdateResponseDto;

import java.util.List;

public interface WriterService {
    LoginResponseDto signUp(String writer, String email, String password);

    LoginResponseDto login(String email, String password);

    List<WriterResponseDto> findAllWriter(Long writer_id);

    WriterResponseDto findWriterById(Long writer_id,Long id);

    WriterUpdateResponseDto updateWriter(Long writer_id,Long id, WriterRequestDto writerRequestDto);

    void deleteWriter(Long writer_id,Long id);
}
