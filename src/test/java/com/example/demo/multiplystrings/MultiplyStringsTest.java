package com.example.demo.multiplystrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class MultiplyStringsTest {


    MultiplyStrings multiplyStrings = new MultiplyStrings();

    @Test
    void shouldMultiplyCorrectly(){

        assertEquals("6", multiplyStrings.multiply("3", "2"));
    }

    @Test
    void shouldMultiplyCorrectly2(){

        assertEquals("1316", multiplyStrings.multiply("47", "28"));
    }


    @Test
    void shouldMultiplyCorrectly3(){

        assertEquals("56088", multiplyStrings.multiply("123", "456"));
    }

    @Test
    void shouldMultiplyCorrectly4(){

        assertEquals("419254329864656431168468",
                multiplyStrings.multiply("498828660196", "840477629533"));
    }
}