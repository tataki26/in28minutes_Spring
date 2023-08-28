package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record: 클래스보다 더 간결한 문법으로 데이터 모델을 정의
// 불변 데이터를 저장하는 데 사용
// getter/setter, 생성자, toString을 정의할 필요가 없다 (자동 생성)
// Bean을 파라미터로 추가하기
record Person(String name, int age, Address address) {};
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
        return new Person("Luna", 20, new Address("Main Street", "LA"));
    }

    // Bean 상호 작용
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 파라미터로 상호 작용
    // 객체(메서드) 이름 유의
    @Bean
    public Person person3Parameters(String name, int age, Address addr2) {
        return new Person(name, age, addr2);
    }

    @Bean
    // Primary가 지정됨에 따라 address는 Primary가 지정된 address를 의미한다
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    // Qualifier로 지정된 address를 의미한다
    public Person person5Qualifier(String name, int age, @Qualifier("address2qualifier") Address address) {
        return new Person(name, age, address);
    }

    // Bean 이름을 지정할 수 있다
    @Bean(name = "addr")
    // Bean을 타입으로 조회할 때 우선 순위를 가짐
    @Primary
    public Address address() {
        return new Address("han-river", "seoul");
    }

    @Bean(name = "addr2")
    @Qualifier("address2qualifier")
    public Address address2() {
        return new Address("baker street", "london");
    }
}
