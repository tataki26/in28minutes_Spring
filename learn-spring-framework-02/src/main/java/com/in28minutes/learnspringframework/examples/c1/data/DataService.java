package com.in28minutes.learnspringframework.examples.c1.data;

import org.springframework.stereotype.Component;

@Component
public interface DataService {
    int[] retrieveData();
}
