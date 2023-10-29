package com.isbill.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MoneyFormDto {

    @NotNull(message = "채무자 선택은 필수입니다.")
    private Long billId;

    @Range(min=0, max=1000000, message = "0~1000000 사이의 가격을 입력해주세요")
    private Long borrowMoney;

    @Range(min=0, max=1000000, message = "0~1000000 사이의 가격을 입력해주세요")
    private Long payMoney;

    private String borrowItemName;

    private String payItemName;
}
