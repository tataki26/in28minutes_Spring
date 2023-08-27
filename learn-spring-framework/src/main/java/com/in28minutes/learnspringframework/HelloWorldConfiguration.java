package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 하나 이상의 Bean 메서드(Bean 생성)를 선언하는 클래스임을 나타냄
// Spring Bean(Spring에서 관리하는 객체) 정의
@Configuration
public class HelloWorldConfiguration {
    // Spring 컨테이너의 관리 대상인 Bean을 생성하는 메서드임을 나타냄
    @Bean
    public String name() {
        return "Ranga";
    }
}
