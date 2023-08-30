package com.in28minutes.learnspringframework.examples.h1;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        // xml 파일로 bean 정의
        try(ClassPathXmlApplicationContext context
                    = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean(Integer.class));
            // run PacmanGame
            context.getBean(GameRunner.class).run();
        }
    }
}
