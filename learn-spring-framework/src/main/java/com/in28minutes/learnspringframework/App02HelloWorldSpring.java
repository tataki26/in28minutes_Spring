package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println(context.getBean("address"));
    }
}
