package com.example.demo.firstmissingpositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositiveTest {

    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();


    @Test
    void shouldReturn3(){

        assertEquals(3, firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
    }

    @Test
    void shouldReturn2(){
        assertEquals(2, firstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    void shouldReturn1(){
        assertEquals(1, firstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }


}