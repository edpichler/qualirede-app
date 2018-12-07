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
public class DoencaRepositoryTest {

    @Autowired
    private DoencaRepository repo;

    @Before
    public void before() {
    }

    @Test
    public void testSaveAndFind() {
        final Doenca doenca = TestUtils.createDoenca();
        repo.save(doenca);
        final Optional<Doenca> byId = repo.findById(doenca.getId());
        assertThat(byId.isPresent()).isTrue();

        //clean
        repo.delete(doenca);
        assertThat(repo.findById(doenca.getId()).isPresent()).isFalse();
    }
}