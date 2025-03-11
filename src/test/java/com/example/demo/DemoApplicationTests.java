package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoApplicationTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testMainMethod() {
        // GIVEN - Set up the context for the test
        String[] args = {}; 

        // WHEN - Execute the main method
        DemoApplication.main(args);

        // THEN - Assert that the application ran successfully
        assertTrue(true); // Replace with a more specific assertion if needed
    }
}