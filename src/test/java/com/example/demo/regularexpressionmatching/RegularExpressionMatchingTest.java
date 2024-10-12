package com.example.demo.regularexpressionmatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();


    @Test
    void shouldNotMatch(){
        assertFalse(regularExpressionMatching.isMatch("aa", "a"));
    }


    @Test
    void shouldMatch(){
        assertTrue(regularExpressionMatching.isMatch("aa", "a*"));
    }

}