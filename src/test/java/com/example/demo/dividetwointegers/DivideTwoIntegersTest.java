package com.example.demo.dividetwointegers;

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

}