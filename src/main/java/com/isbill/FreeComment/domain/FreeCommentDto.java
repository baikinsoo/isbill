package com.isbill.FreeComment.domain;

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
