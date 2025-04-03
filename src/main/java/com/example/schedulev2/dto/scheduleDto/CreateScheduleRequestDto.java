package com.example.schedulev2.dto.scheduleDto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {

    @Size(min=1, max= 20, message = "제목은 1글자부터 20글자까지만 허용됩니다")
    private final String title;

    private final String contents;

}
