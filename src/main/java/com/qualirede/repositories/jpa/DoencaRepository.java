package com.qualirede.repositories.jpa;

import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoencaRepository extends JpaRepository<Doenca, Long> {

}
