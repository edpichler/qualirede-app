package com.qualirede.controller;


import com.qualirede.utils.TestUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Abstract class to test the exposed REST methods.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractResourcesTest {

    protected static final String API_BENEFICIARIO = "/rest/v1/beneficiario";
    protected static final String API_BENEFICIARIO_VINCULAR_DOENCA = "/rest/v1/beneficiario/doenca";
    protected static final String API_DOENCA = "/rest/v1/doenca";
    protected static final String API_USERS_SEARCH_NOME = "/api/users/search/nome";

    protected MockMvc mockMvc;

    @Before
    public void setupMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(getControllersToTest()).build();
    }


    /**
     * Return the list of controllers that are being tested.
     * @return the controllers.
     */
    protected abstract List getControllersToTest();

    @Autowired
    protected TestRestTemplate template;

    /**
     * Get HTTP Entity.
     * @param body
     * @return
     */
    protected HttpEntity<Object> getHttpEntityWithJwt(Object body, String jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        if (jwtToken != null) {
            headers.add( "Authorization", jwtToken);
        }
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

        /**
     * Get HTTP Entity.
     * @param body
     * @return
     */
    protected HttpEntity<Object> getHttpEntity(Object body) {
        return new HttpEntity<>(body);
    }

}
