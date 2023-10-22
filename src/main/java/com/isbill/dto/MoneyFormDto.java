package com.isbill.dto;

import com.isbill.domain.Bill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyFormDto {

    private Long billId;
    private Integer borrowMoney = 0;
    private Integer payMoney = 0;
}
