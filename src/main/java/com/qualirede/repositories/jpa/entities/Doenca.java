package com.qualirede.repositories.jpa.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DOENCAS")
@Data
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "codigo")
    private int codigo;

    @Column(nullable = false, unique = false, name = "descricao")
    private String descricao;
}
