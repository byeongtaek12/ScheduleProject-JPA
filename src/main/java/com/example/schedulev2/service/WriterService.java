package com.example.schedulev2.service;

import com.example.schedulev2.dto.SignUpResponseDto;

public interface WriterService {
    SignUpResponseDto signUp(String writer, String email, String password);

}
