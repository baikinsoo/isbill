package com.isbill.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int borrowMoney;

    private int payMoney;

    private int remainMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Builder
    public Money(Long id, int borrowMoney, int payMoney, int remainMoney, Bill bill) {
        this.id = id;
        this.borrowMoney = borrowMoney;
        this.payMoney = payMoney;
        this.remainMoney = remainMoney;
        this.bill = bill;
    }

    public void plusMoney(int money) {
        int remainMoney = this.remainMoney + money;
        this.remainMoney = remainMoney;
    }

    public void minusMoney(int money) {
        int remainMoney = this.remainMoney - money;
        this.remainMoney = remainMoney;
    }

}
