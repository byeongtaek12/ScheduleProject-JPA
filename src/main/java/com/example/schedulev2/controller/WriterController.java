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
    public ResponseEntity<List<WriterResponseDto>> findAll() {
        List<WriterResponseDto> writerResponseDtoList = writerService.findAll();
        return new ResponseEntity<>(writerResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDto> findById(@PathVariable Long id) {

        WriterResponseDto writerResponseDto = writerService.findById(id);

        return new ResponseEntity<>(writerResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WriterUpdateResponseDto> update(@PathVariable Long id,
                                                                @RequestBody WriterRequestDto writerRequestDto) {

        WriterUpdateResponseDto writerUpdateResponseDto = writerService.updateWriter(id,
                writerRequestDto);

        return new ResponseEntity<>(writerUpdateResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        writerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
