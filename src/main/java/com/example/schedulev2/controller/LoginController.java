package com.example.schedulev2.controller;

import com.example.schedulev2.dto.LoginResponseDto;
import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.service.WriterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final WriterService writerService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> signUp(@RequestBody WriterRequestDto requestDto) {

        LoginResponseDto loginResponseDto = writerService.signUp(requestDto.getWriter(), requestDto.getEmail(),
                requestDto.getPassword());

        return new ResponseEntity<>(loginResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<LoginResponseDto> login(@RequestParam ("email") String email,
                                                  @RequestParam ("password") String password,
                                                  HttpServletRequest request) {

        LoginResponseDto loginResponseDto = writerService.login(email, password);

        HttpSession httpSession = request.getSession(true);

        httpSession.setAttribute("sessionKey", loginResponseDto.getId());

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }
}
