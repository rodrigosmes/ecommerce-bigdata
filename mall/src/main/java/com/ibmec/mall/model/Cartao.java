package com.ibmec.mall.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name="cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String numero;

    @Column
    private LocalDateTime dtExpiracao;

    @Column
    private String cvv;

    @Column
    private Double saldo;
}