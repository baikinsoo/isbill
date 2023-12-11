package com.isbill.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Registre {

    @Id
    @Column(name = "registre_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    @OneToMany(mappedBy = "registre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RegistreBill> registreBills = new ArrayList<>();

    public static Registre createRegistre(Member member) {
        Registre registre = new Registre();
        registre.setMember(member);
        registre.setName(member.getName() + "의 장부");
        return registre;
    }

    public Registre changeName(String name) {
        this.name = name + "의 장부";
        return this;
    }
}
