package com.isbill.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class Bill {

    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<Money> monies = new ArrayList<>();

    @Builder
    public Bill(Long id, String name, List<Money> monies) {
        this.id = id;
        this.name = name;
        this.monies = monies;
    }
}
