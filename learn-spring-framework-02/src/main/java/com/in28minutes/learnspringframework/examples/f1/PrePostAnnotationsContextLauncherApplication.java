package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        // 문구 출력(초기화) 후 Bean 목록이 출력 됨
        System.out.println("All dependencies are ready!");
    }

    // 의존성이 준비된 상태
    // autowiring이 되자마자 해당 어노테이션의 메서드 실행
    // 의존성 주입이 완료된 후에 실행해야 하는 메서드에서 사용
    // 특정 Bean이 다른 Bean을 사용하기 전에 호출되어야 하는 메서드
    @PostConstruct
    public void initialize() {
        // ex:) 데이터베이스에서 데이터를 가져와 초기화
        someDependency.getReady();
    }

    // 애플리케이션이 종료되기 직전에 호출 되는 메서드
    // 컨테이너에서 Bean을 삭제하는 중임을 알리는 콜백
    // 주로 보유하고 있는 리소스를 해제하는 데 사용
    // ex:) 데이터베이스 연결 해제
    @PreDestroy
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic using someDependency");
    }
}
@Configuration
@ComponentScan

public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
