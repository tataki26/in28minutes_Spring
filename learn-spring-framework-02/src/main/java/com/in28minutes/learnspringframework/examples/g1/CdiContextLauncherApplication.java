package com.in28minutes.learnspringframework.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component - Spring 어노테이션
@Named // - CDI 어노테이션
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    // @Autowired - Spring 어노테이션
    @Inject // - CDI 어노테이션
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection ");
        this.dataService = dataService;
    }
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext
                (CdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class)
                    .getDataService());
        }
    }
}
