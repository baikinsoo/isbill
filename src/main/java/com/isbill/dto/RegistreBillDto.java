package com.isbill.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class RegistreBillDto {

    @NotNull(message = "멤버 아이디는 필수 입력 값 입니다.")
    private Long memberId;
}
