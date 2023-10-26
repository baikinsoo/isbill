package com.isbill.dto;

import com.isbill.domain.Bill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyFormDto {

    private Long billId;
    private Integer borrowMoney;
    private Integer payMoney;
    private String borrowItemName;
    private String payItemName;
}
