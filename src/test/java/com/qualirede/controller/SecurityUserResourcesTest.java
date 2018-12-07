package com.qualirede.controller;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Eduardo
 */
public class SecurityUserResourcesTest {// extends AbstractResourcesTest {

//    /**
//     * Test if only ADMIN can Create.
//     */
//    @Test
//    public void testAdminCreate() {
//        final User user = createRandomUser();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityUser(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(403);
//
//        response = template.exchange(API_BENEFICIARIO, HttpMethod.POST, getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        //Delete this user
//        final String selfUrl = response.getBody().getLink("self").getHref();
//        template.exchange(selfUrl, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//    }
//
//    /**
//     * Test if USER and ADMIN can retrieve.
//     */
//    @Test
//    public void testUserAndAdminRetrieve() {
//        final User user = createRandomUser();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        final String self = response.getBody().getLink("self").getHref();
//
//        response = template.exchange(self, HttpMethod.GET, getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//
//        response = template.exchange(self, HttpMethod.GET, getHttpEntityUser(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//
//        //Delete this user
//        final String selfUrl = response.getBody().getLink("self").getHref();
//        template.exchange(selfUrl, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//    }
//
//    /**
//     * Test if a USER with wrong credentials is not allowed to retrieve.
//     */
//    @Test
//    public void testUserInvalidCredentials() {
//        final User user = createRandomUser();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        final String self = response.getBody().getLink("self").getHref();
//
//        response = template.exchange(self, HttpMethod.GET, getHttpEntity(user, "invalid" ,"anyInvalid"), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(401);
//
//        //Delete this user
//        template.exchange(self, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//    }
//
//    /**
//     * Test if USER and ADMIN can search by "nome".
//     */
//    @Test
//    public void testUserAndAdminSearchByNome() {
//        final User user = createRandomUser();
//        final String nome = user.getNome();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        final String searchURL = UriComponentsBuilder.fromPath(API_USERS_SEARCH_NOME)
//                .queryParam("nome", nome).build().toUriString();
//
//        response = template.exchange(searchURL, HttpMethod.GET, getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//        response = template.exchange(searchURL, HttpMethod.GET, getHttpEntityUser(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//
//        //Delete this user
//        final String selfUrl = response.getBody().getLink("self").getHref();
//        template.exchange(selfUrl, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//    }
//
//     /**
//     * Test if only ADMIN can Update.
//     */
//    @Test
//    public void testAdminUpdate() {
//        final User user = createRandomUser();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        final String self = response.getBody().getLink("self").getHref();
//
//        //admin
//        response = template.exchange(self, HttpMethod.PUT, getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//
//        //user
//        response = template.exchange(self, HttpMethod.PUT, getHttpEntityUser(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(403);
//
//        //Delete this user
//        template.exchange(self, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//    }
//
//    /**
//     * Test if only ADMIN can Remove.
//     */
//    @Test
//    public void testAdminRemove() {
//        final User user = createRandomUser();
//
//        ResponseEntity<UserResources> response = template.exchange(API_BENEFICIARIO, HttpMethod.POST,
//                getHttpEntityAdmin(user), UserResources.class);
//        assertThat(response.getStatusCode().value()).isEqualTo(201);
//
//        final String self = response.getBody().getLink("self").getHref();
//
//        //Delete this user
//        ResponseEntity<String> removeResponse = template.exchange(self, HttpMethod.DELETE, getHttpEntityUser(null), String.class);
//        assertThat(removeResponse.getStatusCode().is4xxClientError()).isTrue();
//
//        removeResponse = template.exchange(self, HttpMethod.DELETE, getHttpEntityAdmin(null), String.class);
//        assertThat(removeResponse.getStatusCode().is2xxSuccessful()).isTrue();
//    }

//    @Override
//    protected List getControllersToTest() {
//        return Collections.emptyList();
//    }
}

