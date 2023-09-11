package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or Database
    // InMemory
    @Bean
    public InMemoryUserDetailsManager createUserDetailManager() {
        // withDefaultPasswordEncoder: deprecated
        // this is for simple test
        // UserDetails userDetails = User.withDefaultPasswordEncoder()
        UserDetails userDetails1 = createNewUser("in28minutes", "dummy");
        UserDetails userDetails2 = createNewUser("ranga", "dummydummy");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        return User.builder()
                   .passwordEncoder(passwordEncoder)
                   .username(username)
                   .password(password)
                   .roles("USER", "ADMIN")
                   .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // All URLs are protected
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());

        // A login form is shown for unauthorized request
        http.formLogin(withDefaults());

        // CSRF disable
        // http.csrf().disable(); // deprecated
        // 서로 무관한 함수들도 직렬로 이어지는 메서드 체이닝을 지양하고
        // 함수형으로 수납하는 형태를 지향
        http.csrf(c -> c.disable()); // CSRF 설정을 위한 함수

        // Frames
        // http.headers().frameOptions().disable(); // deprecated
        http.headers(c -> c.frameOptions(f -> f.disable()).disable());

        return http.build();
    }
}
