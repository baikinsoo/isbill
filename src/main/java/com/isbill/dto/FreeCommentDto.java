package com.isbill.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FreeCommentDto {

    private Long freeBoardId;

    private String content;
}
