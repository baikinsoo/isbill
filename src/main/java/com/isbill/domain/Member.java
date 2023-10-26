package com.isbill.domain;

import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;
}
