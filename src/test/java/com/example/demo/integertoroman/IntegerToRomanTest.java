package com.example.demo.integertoroman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    IntegerToRoman integerToRoman = new IntegerToRoman();


    @Test
    void shouldConvertNumberCorrectly(){
        String actualRoman = integerToRoman.intToRoman(3749);

        assertEquals("MMMDCCXLIX", actualRoman);
    }


    @Test
    void shouldConvertNumberCorrectly2(){
        String actualRoman = integerToRoman.intToRoman(58);

        assertEquals("LVIII", actualRoman);
    }

    @Test
    void shouldConvertNumberCorrectly3(){
        String actualRoman = integerToRoman.intToRoman(1994);

        assertEquals("MCMXCIV", actualRoman);
    }
}