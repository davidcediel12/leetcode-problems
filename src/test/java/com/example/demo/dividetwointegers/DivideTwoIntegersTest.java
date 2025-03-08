package com.example.demo.dividetwointegers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTwoIntegersTest {


    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();


    @ParameterizedTest
    @CsvSource(value = {
            "10,3,3",
            "-2147483648,-1,2147483647"
    })
    void shouldDivideCorrectly(int dividend, int divisor, int expectedQuotient) {

        int quotient = divideTwoIntegers.divide(dividend, divisor);

        assertEquals(expectedQuotient, quotient);
    }


    @Test
    void shouldDivideCorrectly2() {

        int quotient = divideTwoIntegers.divide(-2147483648, -1);

        assertEquals(2147483647, quotient);
    }

    @Test
    void shouldDivideCorrectly3() {

        int quotient = divideTwoIntegers.divide(7, -3);

        assertEquals(-2, quotient);
    }

}