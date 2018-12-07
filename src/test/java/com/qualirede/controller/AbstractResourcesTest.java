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
//
//    @Autowired
//    private UserRepository repoUser;
//
//    private User adminUser;
//    private User basicUser;

//    @Before
//    public void criaUsuarios(){
//        //create an user with profile ADMIN.
//        adminUser = createRandomUser();
//        adminUser.setPerfil(Perfil.ADMIN);
//        adminUser.setSenha("adminPassword");
//        repoUser.save(adminUser);
//
//        //create an user with profile USER.
//        basicUser = createRandomUser();
//        basicUser.setPerfil(Perfil.USER);
//        basicUser.setSenha("basicUserPassword");
//        repoUser.save(basicUser);
//    }
//
//    @After
//    public void removeUsuarios() {
//        repoUser.delete(basicUser);
//        repoUser.delete(adminUser);
//    }

    @Before
    public void setupMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(getControllersToTest()).build();
    }

//    /**
//     * Creates an User with Random details (does not persists on database).
//     * @return
//     */
//    protected static User createRandomUser() {
//        User user = new User();
//        final String email = TestUtils.randomEmail();
//        user.setEmail(email);
//        user.setNome("Eduardo Qualirede Test " + System.currentTimeMillis());
//        return user;
//    }

    /**
     * Return the list of controllers that are being tested.
     * @return the controllers.
     */
    protected abstract List getControllersToTest();

    @Autowired
    protected TestRestTemplate template;

    private HttpHeaders createAuthHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    /**
     * Get HTTP Entity.
     * @param body
     * @return
     */
    protected HttpEntity<Object> getHttpEntity(Object body, String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        if (username != null && password != null) {
            headers.addAll( createAuthHeaders(username, password));
        }
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

//    /**
//     * Get HTTP Entity for an User.
//     * @param body
//     * @return
//     */
//    protected HttpEntity<Object> getHttpEntityUser(Object body) {
//        return getHttpEntity(body, basicUser.getEmail(), basicUser.getSenha());
//    }
//
//    /**
//     * Get HTTP Entity for an Admin user.
//     * @param body
//     * @return
//     */
//    protected HttpEntity<Object> getHttpEntityAdmin(Object body) {
//        return getHttpEntity(body, adminUser.getEmail(), adminUser.getSenha());
//    }
}
