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

    @Test
    void shouldMatchFreeChar(){
        assertTrue(regularExpressionMatching.isMatch("ab", ".*"));
    }

    @Test
    void shouldMatchIgnoringZeroExpressions(){
        assertTrue(regularExpressionMatching.isMatch("aab", "c*a*b"));
    }


    @Test
    void shouldMatchMississippi(){
        assertTrue(regularExpressionMatching.isMatch("mississippi", "mis*is*ip*."));
    }

    @Test
    void shouldNotMatchMississippi(){
        assertFalse(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
    }

}