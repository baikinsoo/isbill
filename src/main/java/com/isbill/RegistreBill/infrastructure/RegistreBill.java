package com.isbill.RegistreBill.infrastructure;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Registre.infrastructure.Registre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RegistreBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registre_id")
    private Registre registre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
