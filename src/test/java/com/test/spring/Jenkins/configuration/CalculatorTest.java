package com.test.spring.Jenkins.configuration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTest {

    @Test
    void sum() {
        //GIVEN 1 + 2
        assertEquals(4 , Calculator.sum(1,3) );
    }

    @Test
    void multiple() {
        //GIVEN 9*9
        assertEquals(81 , Calculator.multiple(9,9) );
    }

    @Test
    void divison() {
        //GIVEN 8/4
        assertEquals(4 , Calculator.divison(8,2) );
        assertEquals(8 , Calculator.divison(16,2) );
    }

    @Test
    void sous() {
        //GIVEN 10-5
        assertEquals(5 , Calculator.sous(10,5) );
    }

    @Test
    @DisplayName("sum with other methode")
    void sumTwoVar() {
        //GIVEN 1 + 2
        assertEquals(4 , Calculator.sum(1,3) );
    }
}