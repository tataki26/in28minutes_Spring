package com.in28minutes.junitin5steps.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    @Test
    void test() {
        // [강제] 테스트 통과X
        // fail("Not yet implemented");

        int[] numbers = {1,2,3};
        MyMath math = new MyMath();
        int result = math.calculateSum(numbers);
        System.out.println(result);
        int expectedResult = 5;
        assertEquals(expectedResult, result);

        // Absence of failure is success
        // Test Condition or Assert
    }
}