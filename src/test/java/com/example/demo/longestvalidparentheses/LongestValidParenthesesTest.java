package com.example.demo.longestvalidparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {


    LongestValidParentheses validator = new LongestValidParentheses();


    @Test
    void shouldReturnMaxValidParenthesesCorrectly(){
        assertEquals(2, validator.longestValidParentheses("(()"));
    }

    @Test
    void shouldReturnMaxValidParenthesesCorrectly2(){
        assertEquals(4, validator.longestValidParentheses(")()())"));
    }

    @Test
    void shouldReturnMaxValidParenthesesCorrectly3(){
        assertEquals(0, validator.longestValidParentheses(""));
    }

    @Test
    void shouldReturnMaxValidParenthesesCorrectly4(){
        assertEquals(2, validator.longestValidParentheses("()(()"));
    }

    @Test
    void shouldReturnMaxValidParenthesesCorrectly5(){
        assertEquals(6, validator.longestValidParentheses("()(())"));
    }


    @Test
    void shouldReturnMaxValidParenthesesCorrectly6(){
        assertEquals(2, validator.longestValidParentheses("))))((()(("));
    }


}