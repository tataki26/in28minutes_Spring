package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole gamingConsole;

    public GameRunner(GamingConsole gamingConsole) {
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
