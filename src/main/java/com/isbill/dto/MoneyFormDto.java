package com.isbill.dto;

import com.isbill.domain.Bill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyFormDto {

    private String name;
    private Integer borrowMoney;
    private Integer payMoney;
}
