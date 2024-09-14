package com.example.demo.reverseinteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void shouldReverseProperly(){

        Integer actual = reverseInteger.reverse(123);
        assertEquals(321, actual);
    }

    @Test
    void shouldReverse120Properly(){

        Integer actual = reverseInteger.reverse(120);
        assertEquals(21, actual);
    }

    @Test
    void shouldReverseProperlyWhenNegativeNumber(){

        Integer actual = reverseInteger.reverse(-123);
        assertEquals(-321, actual);
    }


    @Test
    void shouldR2(){

        Integer actual = reverseInteger.reverse(1534236469);
        assertEquals(0, actual);
    }

}