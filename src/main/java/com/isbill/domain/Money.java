package com.isbill.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer borrowMoney = 0;

    private Integer payMoney = 0;

    private Integer remainMoney = 0;

    private Integer borrowMoneyAll = 0;

    private Integer payMoneyAll = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
