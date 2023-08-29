package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Bean 생성
@Component
class MyBusinessClass {
    // 의존성 주입 - 필드 주입
    // 리플렉션(실행 중인 프로그램의 클래스 등의 정보를 분석하고 조작할 수 있는 능력 - 동적 변경)을 통해 주입
    // @Autowired
    Dependency1 dependency1;
    // @Autowired
    Dependency2 dependency2;

    /*
    // 의존성 주입 - setter(수정자) 주입
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }
    */

    // 의존성 주입 - 생성자 주입
    // Spring 프레임워크가 권장하는 방식
    // 모든 초기화가 하나의 메서드에서 발생
    // 초기에 값을 설정(setter)할 수 있으면서 이후 값이 변경되는 것을 방지할 수 있음
    // Autowired 생략 가능
    // @Autowired
    public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - MyBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
// 같은 패키지에 컴포넌트가 존재하는 경우 명시적으로 패키지를 지정 할 필요가 없다
@ComponentScan
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (DepInjectionLauncherApplication.class)) {
            // Spring에 필수적인 Bean들이 출력된다
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(MyBusinessClass.class));
        }
    }
}
