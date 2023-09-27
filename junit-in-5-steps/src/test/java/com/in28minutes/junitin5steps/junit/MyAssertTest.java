package com.in28minutes.junitin5steps.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {
    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    @Test
    void test() {
        // boolean
        assertEquals(true, todos.contains("AWS"));
        assertTrue(todos.contains("Azure"));
        assertFalse(todos.contains("Go"));
        // assertNull, assertNotNull
        assertArrayEquals(new int[] {1,2}, new int[] {1,2});

        // int
        assertEquals(3, todos.size());
    }
}
