package com.example.demo.reverseinteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void shouldReverseProperly(){

        Integer actual = reverseInteger.reverse2(123);
        assertEquals(321, actual);
    }

    @Test
    void shouldReverse120Properly(){

        Integer actual = reverseInteger.reverse2(120);
        assertEquals(21, actual);
    }

    @Test
    void shouldReverseProperlyWhenNegativeNumber(){

        Integer actual = reverseInteger.reverse2(-123);
        assertEquals(-321, actual);
    }


    @Test
    void shouldReturnZeroWhenNumberIsTooBig(){

        Integer actual = reverseInteger.reverse2(1534236469);
        assertEquals(0, actual);
    }

    @Test
    void shouldReturnOne(){

        Integer actual = reverseInteger.reverse2(10);
        assertEquals(1, actual);
    }

}