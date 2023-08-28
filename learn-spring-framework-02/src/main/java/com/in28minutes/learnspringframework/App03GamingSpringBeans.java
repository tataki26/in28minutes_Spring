package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App03GamingSpringBeans {
    @Bean
    public GamingConsole gamingConsole() {
        return new MarioGame();
    }

    @Bean
    // 기존에 등록된 Bean 연결 하기(Wiring)
    public GameRunner gameRunner(GamingConsole gamingConsole) {
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
