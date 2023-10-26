package com.isbill.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long borrowMoney = 0L;

    private Long payMoney = 0L;

    private Long remainMoney = 0L;

    private Long borrowMoneyAll = 0L;

    private Long payMoneyAll = 0L;

    private String borrowItemName = "     ";

    private String payItemName = "     ";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
