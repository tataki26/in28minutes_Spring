package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record: 클래스보다 더 간결한 문법으로 데이터 모델을 정의
// 불변 데이터를 저장하는 데 사용
// getter/setter, 생성자, toString을 정의할 필요가 없다 (자동 생성)
record Person(String name, int age) {};
record Address(String firstLine, String city) {};

// 하나 이상의 Bean 메서드(Bean 생성)를 선언하는 클래스임을 나타냄
// Spring Bean(Spring에서 관리하는 객체) 정의
@Configuration
public class HelloWorldConfiguration {
    // Spring 컨테이너의 관리 대상인 Bean을 생성하는 메서드임을 나타냄
    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 30;
    }

    @Bean
    public Person person() {
        // 생성자 없이도 new 사용 (자동 생성)
        return new Person("Luna", 20);
    }

    @Bean
    public Address address() {
        return new Address("han-river", "seoul");
    }
}
