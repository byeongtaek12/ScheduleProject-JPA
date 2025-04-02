package com.example.schedulev2.service;

import com.example.schedulev2.dto.LoginResponseDto;
import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.dto.WriterUpdateResponseDto;

import java.util.List;

public interface WriterService {
    LoginResponseDto signUp(String writer, String email, String password);

    List<WriterResponseDto> findAll();

    WriterResponseDto findById(Long id);

    WriterUpdateResponseDto updateWriter(Long id, WriterRequestDto writerRequestDto);

    void delete(Long id);

    LoginResponseDto login(String email, String password);
}
