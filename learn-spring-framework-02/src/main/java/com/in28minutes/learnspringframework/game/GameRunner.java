package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole gamingConsole;

    // 한정자에 따라 @Primary 클래스가 아닌 @Qualifier 클래스가 주입된다
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

    public void run() {
        System.out.println("Running game: " + gamingConsole);

        gamingConsole.up();
        gamingConsole.down();
        gamingConsole.left();
        gamingConsole.right();
    }
}
