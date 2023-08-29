package com.in28minutes.learnspringframework.examples.c1;

import com.in28minutes.learnspringframework.examples.c1.data.DataService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
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
