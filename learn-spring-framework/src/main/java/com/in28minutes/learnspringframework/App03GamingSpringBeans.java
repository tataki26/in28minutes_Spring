package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (GamingConfiguration.class)) {
            GameRunner marioGameRunner = new GameRunner(context.getBean(MarioGame.class));
            marioGameRunner.run();

            GameRunner superContraGameRunner = new GameRunner(context.getBean(SuperContraGame.class));
            superContraGameRunner.run();

            GameRunner pacmanGameRunner = new GameRunner(context.getBean(PacmanGame.class));
            pacmanGameRunner.run();

            GameRunner gameRunner = new GameRunner(context.getBean(GamingConsole.class));
            gameRunner.run();
        }
    }
}
