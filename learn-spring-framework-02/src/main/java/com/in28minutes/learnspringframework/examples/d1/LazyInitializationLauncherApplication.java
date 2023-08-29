package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
// default는 즉시 로딩
// 이 어노테이션을 사용하면 애플리케이션 실행 시점에 ClassB Bean이 초기화 되지 않고
// ClassB Bean을 사용하는 시점에 초기화 된다
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // 초기화 시 다른 로직을 추가해도 된다
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (LazyInitializationLauncherApplication.class)) {

            // 즉시 로딩
            // Spring Context를 실행하면 초기화가 자동으로 일어난다
            // ClassB Bean의 메서드를 호출하지 않아도 초기화가 자동으로 일어난다
            // 아무 코드 없이 ClassB 생성자의 출력 로직이 실행된다

            // 지연 로딩
            System.out.println("Initialization of context is completed");
            // 이 때, ClassB가 초기화 된다
            context.getBean(ClassB.class).doSomething();
        }
    }
}
