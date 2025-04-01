package com.example.schedulev2.service;

import com.example.schedulev2.dto.WriterResponseDto;

import java.util.List;

public interface WriterService {
    WriterResponseDto signUp(String writer, String email, String password);

    List<WriterResponseDto> findAll();
}
