package com.example.demo.stringtointeger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    StringToInteger stringToInteger = new StringToInteger();


    @Test
    void shouldTransformProperly(){
        int actual = stringToInteger.myAtoi("42");
        assertEquals(42, actual);
    }


    @Test
    void shouldTransformProperly2(){
        int actual = stringToInteger.myAtoi("words and 987");
        assertEquals(0, actual);
    }


    @Test
    void shouldTransformProperly3(){
        int actual = stringToInteger.myAtoi("0-1");
        assertEquals(0, actual);
    }


    @Test
    void shouldRoundToMinIntegerNumber(){
        int actual = stringToInteger.myAtoi("-91283472332");
        assertEquals(-2147483648, actual);
    }

    @Test
    void shouldTransformProperly4(){
        int actual = stringToInteger.myAtoi("+-12");
        assertEquals(0, actual);
    }

    @Test
    void shouldTransformProperly5(){
        int actual = stringToInteger.myAtoi("2147483648");
        assertEquals(2147483647, actual);
    }


}