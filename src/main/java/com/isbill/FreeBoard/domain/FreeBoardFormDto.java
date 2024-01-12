package com.isbill.FreeBoard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FreeBoardFormDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @Lob
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    private MultipartFile attachFile;

    private String imgName;
}
