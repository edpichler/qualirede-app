package com.qualirede.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private UserRepository repo;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        final Optional<User> optFound = repo.findOneByEmailIgnoreCase(name);
//        if (optFound.isPresent() && optFound.get().getSenha().equals(password)) {
//            //authenticou
//
//            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//                    name, password, getRoles(name));
//            return auth;
//        }else {
            throw new BadCredentialsException("User could not be authenticated.");
//        }
    }

//    private List<GrantedAuthority> getRoles(String email) {
//        final Optional<User> optFound = repo.findOneByEmailIgnoreCase(email.trim());
//        List<GrantedAuthority> authorities = new ArrayList();
//        if (optFound.isPresent()) {
//            final User userFound = optFound.get();
//            final String perfil = userFound.getPerfil().toString();
//            final SimpleGrantedAuthority simpleRole = new SimpleGrantedAuthority("ROLE_" + perfil);
//            authorities.add(simpleRole);
//        }
//        return authorities;
//    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}