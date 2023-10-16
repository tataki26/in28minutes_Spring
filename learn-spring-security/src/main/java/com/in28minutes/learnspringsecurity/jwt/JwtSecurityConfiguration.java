package com.in28minutes.learnspringsecurity.jwt;

import com.in28minutes.learnspringsecurity.basic.UserRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class JwtSecurityConfiguration {
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
        // configure HTTP basic authentication
        http.httpBasic();
        // disable csrf
        http.csrf().disable();
        // same origin request -> enable frame option
        http.headers().frameOptions().sameOrigin();
        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        UserDetails user = User.withUsername("in28minutes")
                //.password("{noop}dummy")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(UserRoles.USER.name())
                .build();

        UserDetails admin = User.withUsername("admin")
                //.password("{noop}dummy")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(UserRoles.ADMIN.name(), UserRoles.USER.name())
                .build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }
}
