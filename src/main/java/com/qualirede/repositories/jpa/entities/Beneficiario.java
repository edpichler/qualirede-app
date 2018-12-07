package com.qualirede.repositories.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BENEFICIARIOS")
@Data
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, name = "nome")
    private String nome;

    @Column(nullable = false, unique = false, name = "dtNascimento")
    private LocalDate dtNascimento;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Doenca> doencas = new ArrayList();
}
