package com.example.schedulev2.controller;

import com.example.schedulev2.dto.SignUpRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writers")
@RequiredArgsConstructor
public class WriterController {

    private final WriterService writerService;

    @PostMapping
    public ResponseEntity<WriterResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        WriterResponseDto signUpResponseDto = writerService.signUp(requestDto.getWriter(), requestDto.getEmail(),
                requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WriterResponseDto>> findAll() {
        List<WriterResponseDto> writerResponseDtoList = writerService.findAll();
        return new ResponseEntity<>(writerResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDto> findById(@PathVariable Long id) {

        WriterResponseDto writerResponseDto = writerService.findById(id);

        return new ResponseEntity<>(writerResponseDto,HttpStatus.OK);
    }


}
