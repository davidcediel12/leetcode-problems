package com.example.demo.wildcardmatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardMatchingTest {


    WildCardMatching wildCardMatching = new WildCardMatching();


    @Test
    void shouldReturnCorrectMatch(){

        assertFalse(wildCardMatching.isMatch("aa", "a"));
    }


    @Test
    void shouldReturnCorrectMatch2(){

        assertTrue(wildCardMatching.isMatch("aa", "*"));
    }

    @Test
    void shouldReturnCorrectMatch3(){

        assertFalse(wildCardMatching.isMatch("cb", "?a"));
    }



}