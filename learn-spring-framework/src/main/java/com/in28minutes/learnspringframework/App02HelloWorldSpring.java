package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1) Spring Application or Spring Context 실행하기
        // @Configuration 클래스(설정 파일)로 Spring Context 생성하기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2) @Configuration: Spring Framework의 관리 대상 설정하기
        // 메서드 이름으로 Bean 조회하기(호출하기)
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("addr"));

        // 타입으로 Bean 조회하기
        System.out.println(context.getBean(Address.class));

        // 다른 Bean과 상호 작용 1 - 메서드 호출
        System.out.println(context.getBean("person2MethodCall"));
        // 다른 Bean과 상호 작용 2 - 파라미터
        System.out.println(context.getBean("person3Parameters"));

        // 등록된 Spring Bean 나열하기
        // 함수형 프로그래밍 - 메서드 참조
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        // 등록된 Spring Bean 수 나열하기
        // context.getBeanDefinitionCount();

        // Primary 설정
        System.out.println(context.getBean("person4Parameters"));
        // Qualifier 설정
        System.out.println(context.getBean("person5Qualifier"));
    }
}
