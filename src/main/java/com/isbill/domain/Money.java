package com.isbill.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@ToString
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
