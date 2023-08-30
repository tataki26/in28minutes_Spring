package com.in28minutes.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 기본적으로 Spring 프레임워크에서 생성되는 모든 Bean들은 싱글톤 객체
// Bean을 참조할 때마다 매번 동일한 Bean 반환
// Singleton Bean: Spring IoC 컨테이너 당 객체 인스턴스가 딱 하나
@Component
class NormalClass {
}

// 매번 새로운 인스턴스를 반환받고 싶으면 PROTOTYPE 옵션을 설정할 것
// Prototype Bean: Spring IoC 컨테이너 당 객체 인스턴스가 여러 개
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopestLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (BeanScopestLauncherApplication.class)) {
            // 동일한 객체 (해시 코드)
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // 서로 다른 객체 - 호출할 때마다 새로운 Bean(새로운 인스턴스) 조회
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
