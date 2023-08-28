package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Spring이 관리하는 컴포넌트
// 어노테이션 기반의 Configuration과 Component Scanning의 대상
// Spring이 객체 생성을 대신해준다
@Component
// Auto-Wiring 시, 여러 후보가 단일 의존성의 자격을 가질 경우 Bean에 우선권을 부여하는 옵션
// 이 옵션을 생략하면 구현체가 여러 개이므로 NoUniqueBeanDefinitionException 예외가 발생한다
@Primary
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
