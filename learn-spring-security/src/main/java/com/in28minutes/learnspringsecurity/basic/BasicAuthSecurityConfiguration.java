package com.in28minutes.learnspringsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth ->{
                    // apply authorization to all requests
                    auth.anyRequest().authenticated();
                });
        // set session stateless
        http.sessionManagement(
                session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS));
        // pop-up
        // http.formLogin(); // use default login page
        // configure HTTP basic authentication
        http.httpBasic();
        // disable csrf
        http.csrf().disable();
        return http.build();
    }
}
