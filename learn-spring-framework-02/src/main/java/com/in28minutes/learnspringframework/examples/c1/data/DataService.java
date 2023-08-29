package com.in28minutes.learnspringframework.examples.c1.data;

import org.springframework.stereotype.Component;

// 인터페이스에는 @Component를 붙이지 않아도 된다
// @Component
public interface DataService {
    int[] retrieveData();
}
