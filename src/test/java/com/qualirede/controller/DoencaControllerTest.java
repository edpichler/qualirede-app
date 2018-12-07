package com.qualirede.controller;

import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;
import com.qualirede.utils.TestUtils;
import org.junit.Test;
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
public class DoencaControllerTest extends AbstractResourcesTest {

    /**
     * Test CREATE and GET methods.
     */
    @Test
    public void testDoencaCreateAndGet() {
        final Doenca doenca  = TestUtils.createDoenca();
        final String descricao = doenca.getDescricao();
        //create
        final ResponseEntity<Long> response = template.exchange(API_DOENCA, HttpMethod.POST,
                getHttpEntity(doenca, null, null), Long.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().longValue()).isGreaterThan(0);

        //get
        final UriComponents path = UriComponentsBuilder.fromPath(API_DOENCA).path("/" + response.getBody().toString()).build();

        final ResponseEntity<Doenca> getBenef = template.exchange(path.toUriString(), HttpMethod.GET, null, Doenca.class);
        assertThat(getBenef.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(getBenef.getBody().getDescricao()).isEqualTo(doenca.getDescricao());
    }

    @Override
    protected List getControllersToTest() {
        return Collections.EMPTY_LIST;
    }
}