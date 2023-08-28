package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole gamingConsole() {
        return new MarioGame();
    }

    @Bean
    // 기존에 등록된 Bean 연결 하기(Wiring)
    public GameRunner gameRunner(GamingConsole gamingConsole) {
        return new GameRunner(gamingConsole);
    }
}
