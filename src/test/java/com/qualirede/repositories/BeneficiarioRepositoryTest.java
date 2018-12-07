package com.qualirede.repositories;
import com.qualirede.repositories.jpa.BeneficiarioRepository;
import com.qualirede.repositories.jpa.DoencaRepository;
import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;
import com.qualirede.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class BeneficiarioRepositoryTest {

    @Autowired
    private BeneficiarioRepository repoBeneficiario;

    @Autowired
    private DoencaRepository repoDoenca;


    @Before
    public void before() {
    }

    @Test
    public void testSaveAndFind() {
        final Beneficiario ben = TestUtils.createBeneficiario();
        repoBeneficiario.save(ben);
        final Optional<Beneficiario> byId = repoBeneficiario.findById(ben.getId());
        assertThat(byId.isPresent()).isTrue();

        //clean
        repoBeneficiario.delete(ben);
        assertThat(repoBeneficiario.findById(ben.getId()).isPresent()).isFalse();
    }

    @Test
    public void testBeneficiarioDoencasAssociation() {
        final Doenca doenca = TestUtils.createDoenca();
        repoDoenca.save(doenca);

        final Beneficiario ben = TestUtils.createBeneficiario();
        ben.getDoencas().add(doenca);
        repoBeneficiario.save(ben);

        final Optional<Beneficiario> byId = repoBeneficiario.findById(ben.getId());
        assertThat(byId.isPresent()).isTrue();
        assertThat(byId.get().getDoencas().size()).isEqualTo(1);

        //clean
        repoBeneficiario.delete(ben);
        repoDoenca.delete(doenca);
    }
}