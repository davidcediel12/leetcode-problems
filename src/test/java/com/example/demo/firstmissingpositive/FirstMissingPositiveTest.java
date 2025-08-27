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
    void shouldReturn2WhenJustOneIsPresent(){
        assertEquals(2, firstMissingPositive.firstMissingPositive(new int[]{1}));
    }

    @Test
    void shouldReturn2WhenJustOneIsPresentTwice(){
        assertEquals(2, firstMissingPositive.firstMissingPositive(new int[]{1, 1}));
    }


}