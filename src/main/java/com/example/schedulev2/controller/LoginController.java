package com.example.schedulev2.controller;

import com.example.schedulev2.dto.loginDto.LoginReqeustDto;
import com.example.schedulev2.dto.loginDto.LoginResponseDto;
import com.example.schedulev2.service.writerService.WriterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final static String SESSION_KEY = "sessionKey";
    private final WriterService writerService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDto> signUp(@Valid @RequestBody LoginReqeustDto requestDto) {

        LoginResponseDto loginResponseDto = writerService.signUp(requestDto.getWriter(), requestDto.getEmail(),
                requestDto.getPassword());

        return new ResponseEntity<>(loginResponseDto, HttpStatus.CREATED);
    }

    // 로그인
    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestParam ("email") String email,
                                                  @RequestParam ("password") String password,
                                                  HttpServletRequest request) {

        LoginResponseDto loginResponseDto = writerService.login(email, password);

        HttpSession httpSession = request.getSession(true);

        httpSession.setAttribute(SESSION_KEY, loginResponseDto.getId());

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {

        HttpSession httpSession = request.getSession(false);

        httpSession.invalidate();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
