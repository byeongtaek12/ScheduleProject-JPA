package com.example.schedulev2.controller;

import com.example.schedulev2.dto.WriterRequestDto;
import com.example.schedulev2.dto.WriterResponseDto;
import com.example.schedulev2.dto.WriterUpdateResponseDto;
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

    @GetMapping
    public ResponseEntity<List<WriterResponseDto>> findAllWriter() {

        List<WriterResponseDto> writerResponseDtoList = writerService.findAllWriter();

        return new ResponseEntity<>(writerResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDto> findWriterById(@PathVariable Long id) {

        WriterResponseDto writerResponseDto = writerService.findWriterById(id);

        return new ResponseEntity<>(writerResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WriterUpdateResponseDto> updateWriter(@PathVariable Long id,
                                                                @RequestBody WriterRequestDto writerRequestDto) {

        WriterUpdateResponseDto writerUpdateResponseDto = writerService.updateWriter(id,
                writerRequestDto);

        return new ResponseEntity<>(writerUpdateResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWriter(@PathVariable Long id) {

        writerService.deleteWriter(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    private boolean isSession(HttpServletRequest httpServletRequest) {
//        HttpSession session = httpServletRequest.getSession(false);
//
//        if (session==null || session.getAttribute("sessionKey")==null) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED," 로그인을 한 다음 이용해주세요");
//        }
//        return true;
//    }
}
