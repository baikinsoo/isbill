package com.isbill.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class UpBoardFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String title;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String content;
}
