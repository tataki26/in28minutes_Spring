package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

// Spring이 관리하는 컴포넌트
// 어노테이션 기반의 Configuration과 Component Scanning의 대상
// Spring이 객체 생성을 대신해준다
@Component
public class MarioGame implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Accelerate");
    }
}
