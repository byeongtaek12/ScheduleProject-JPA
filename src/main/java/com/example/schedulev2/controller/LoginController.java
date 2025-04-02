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

        LoginResponseDto signUpResponseDto = writerService.signUp(requestDto.getWriter(), requestDto.getEmail(),
                requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<LoginResponseDto> login(@RequestParam ("email") String email,
                                                  @RequestParam ("password") String password,
                                                  HttpServletRequest request) {

        LoginResponseDto loginResponseDto = writerService.login(email, password);

        HttpSession httpSession = request.getSession(true);

        httpSession.setAttribute("sessionKey", email.charAt(0)+password.charAt(0));

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }
}
