package com.in28minutes.learnspringframework.examples.c1;

import com.in28minutes.learnspringframework.examples.c1.data.DataService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

// @Component
// 비즈니스 로직을 다루는 컴포넌트
@Service
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays
                .stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
