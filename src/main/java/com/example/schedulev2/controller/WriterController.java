package com.example.schedulev2.controller;

import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.dto.WriterUpdateResponseDto;
import com.example.schedulev2.service.WriterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping
    public ResponseEntity<List<WriterResponseDto>> findAllWriter(HttpServletRequest httpServletRequest) {

        List<WriterResponseDto> writerResponseDtoList = writerService.findAllWriter(getSessionKey(httpServletRequest));

        return new ResponseEntity<>(writerResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDto> findWriterById(@PathVariable Long id,
                                                            HttpServletRequest httpServletRequest) {

        WriterResponseDto writerResponseDto = writerService.findWriterById(getSessionKey(httpServletRequest),id);

        return new ResponseEntity<>(writerResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WriterUpdateResponseDto> updateWriter(@PathVariable Long id,
                                                                @RequestBody WriterRequestDto writerRequestDto,
                                                                HttpServletRequest httpServletRequest) {

        WriterUpdateResponseDto writerUpdateResponseDto = writerService.updateWriter(getSessionKey(httpServletRequest),
                id, writerRequestDto);

        return new ResponseEntity<>(writerUpdateResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWriter(@PathVariable Long id, HttpServletRequest httpServletRequest) {

        writerService.deleteWriter(getSessionKey(httpServletRequest),id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Long getSessionKey(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        return (Long) session.getAttribute("sessionKey");
    }

}
