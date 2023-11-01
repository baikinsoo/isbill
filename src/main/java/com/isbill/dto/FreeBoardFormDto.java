package com.isbill.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class FreeBoardFormDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @Lob
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
}
