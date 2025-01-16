package com.example.demo.romantointeger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    RomanToInteger romanToInteger = new RomanToInteger();


    @Test
    void shouldTransformRomanCorrectly(){
        int obtainedNum = romanToInteger.romanToInt("III");
        assertEquals(3, obtainedNum);
    }


    @Test
    void shouldTransformRomanCorrectly1(){
        int obtainedNum = romanToInteger.romanToInt("LVIII");
        assertEquals(58, obtainedNum);
    }

    @Test
    void shouldTransformRomanCorrectly2(){
        int obtainedNum = romanToInteger.romanToInt("MCMXCIV");
        assertEquals(1994, obtainedNum);
    }

}