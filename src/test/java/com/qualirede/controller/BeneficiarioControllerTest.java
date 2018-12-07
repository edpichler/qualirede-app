package com.qualirede.controller;

import com.qualirede.controller.json.BeneficiarioDoencaDTO;
import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;
import com.qualirede.utils.TestUtils;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Eduardo
 */
public class BeneficiarioControllerTest extends AbstractResourcesTest {

    /**
     * Test CREATE and GET methods.
     */
    @Test
    public void testBeneficiarioCreateAndGet() {
        final Beneficiario bene  = TestUtils.createBeneficiario();
        final LocalDate dtNascimento = bene.getDtNascimento();
        final String nome = bene.getNome();

        //create
        final ResponseEntity<Long> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
                getHttpEntity(bene, null, null), Long.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().longValue()).isGreaterThan(0);

        //get
        final UriComponents path = UriComponentsBuilder.fromPath(API_BENEFICIARIO).path("/" + response.getBody().toString()).build();

        final ResponseEntity<Beneficiario> getBenef = template.exchange(path.toUriString(), HttpMethod.GET, null, Beneficiario.class);
        assertThat(getBenef.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(getBenef.getBody().getDtNascimento()).isEqualTo(dtNascimento);
        assertThat(getBenef.getBody().getNome()).isEqualTo(nome);
    }

    /**
     * Test Vincular doença e GET lista de Doencas do beneficiário.
     */
    @Test
    public void testBeneficiarioVincularDoenca() {
        final Beneficiario bene  = TestUtils.createBeneficiario();
        final String nomeBeneficiario = bene.getNome();

        //create beneficiario
        final ResponseEntity<Long> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
                getHttpEntity(bene, null, null), Long.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        long idBeneficiario = response.getBody().longValue();

        //create algumas doencas, e atribui ao beneficiario
        final int qtde = 2;
        for (int i = 0; i < qtde; i++) {

            //create doenca
            final Doenca doenca  = TestUtils.createDoenca();
            String nomeDoenca = doenca.getDescricao();
            final ResponseEntity<Long> responseDoenca = template.exchange(API_DOENCA, HttpMethod.POST,
                    getHttpEntity(doenca, null, null), Long.class);
            assertThat(responseDoenca.getStatusCode().is2xxSuccessful()).isTrue();

            //vincula doenca
            BeneficiarioDoencaDTO dto = new BeneficiarioDoencaDTO();
            dto.setIdBeneficiario(idBeneficiario);
            dto.setIdDoenca(responseDoenca.getBody().longValue());

            final ResponseEntity<String> responseVincular = template.exchange(API_BENEFICIARIO_VINCULAR_DOENCA, HttpMethod.POST,
                    getHttpEntity(dto, null, null), String.class);
            assertThat(responseVincular.getStatusCode().is2xxSuccessful()).isTrue();
            assertThat(responseVincular.getBody()).isEqualTo("Beneficiário " + nomeBeneficiario +
                    " vinculado à doença " + nomeDoenca +
                    " com sucesso.");
        }

        //get
        final UriComponents path = UriComponentsBuilder.fromPath(API_BENEFICIARIO).path("/" + response.getBody().toString())
                .path("/doencas")
                .build();
        final ParameterizedTypeReference<List<Doenca>> typeReference = new ParameterizedTypeReference<List<Doenca>>() {};

        final ResponseEntity<List<Doenca>> listaDoencas = template.exchange(path.toUriString(), HttpMethod.GET, null, typeReference);
        assertThat(listaDoencas.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(listaDoencas.getBody().size()).isEqualTo(qtde);
    }

    @Override
    protected List getControllersToTest() {
        return Collections.EMPTY_LIST;
    }
}