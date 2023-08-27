package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame();
        SuperContraGame superContraGame = new SuperContraGame();
        PacmanGame pacmanGame = new PacmanGame();

        GameRunner marioGameRunner = new GameRunner(marioGame);
        marioGameRunner.run();

        GameRunner superContraGameRunner = new GameRunner(superContraGame);
        superContraGameRunner.run();

        GameRunner pacmanGameRunner = new GameRunner(pacmanGame);
        pacmanGameRunner.run();
    }
}
