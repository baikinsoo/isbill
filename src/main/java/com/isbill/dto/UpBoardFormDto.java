package com.isbill.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpBoardFormDto {

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;

    @Lob
    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String content;
}
