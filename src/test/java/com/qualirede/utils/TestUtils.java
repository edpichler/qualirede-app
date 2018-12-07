package com.qualirede.utils;

import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;

import java.time.LocalDate;

/**
 * Class with utility methods for tests.
 */
public class TestUtils {

    public static Beneficiario createBeneficiario() {
        final Beneficiario ben = new Beneficiario();
        ben.setDtNascimento(LocalDate.now());
        ben.setNome("Nome");
        return ben;
    }

    public static Doenca createDoenca() {
        final Doenca doenca = new Doenca();
        doenca.setDescricao("Doenca " + System.currentTimeMillis());
        doenca.setCodigo((int) (Math.random() * Integer.MAX_VALUE));
        return doenca;
    }
}
