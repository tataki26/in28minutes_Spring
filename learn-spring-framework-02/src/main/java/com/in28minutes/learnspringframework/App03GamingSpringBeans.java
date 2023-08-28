package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 다른 패키지에 정의된 Component 클래스를 찾는다
@ComponentScan("com.in28minutes.learnspringframework.game")
public class App03GamingSpringBeans {
    @Bean
    // 기존에 등록된 Bean 연결 하기(Wiring) ==> Auto-Wiring
    public GameRunner gameRunner(GamingConsole gamingConsole) {
        // 많은 GamingConsole 구현체 중에서 Component Scanning의 대상인 MarioGame을 연결해준다
        System.out.println("Parameter: " + gamingConsole);
        return new GameRunner(gamingConsole);
    }

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (App03GamingSpringBeans.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
