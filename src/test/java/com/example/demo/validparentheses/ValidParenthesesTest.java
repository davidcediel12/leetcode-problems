package com.example.demo.validparentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();


    @ParameterizedTest
    @ValueSource(strings = {
            "()", "()[]{}", "([])"
    })
    void givenValidParenthesesShouldReturnTrue(String s) {

        assertTrue(validParentheses.isValid(s));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "(]", "]"
    })
    void givenInvalidParenthesesShouldReturnFalse(String s) {

        assertFalse(validParentheses.isValid(s));
    }

}