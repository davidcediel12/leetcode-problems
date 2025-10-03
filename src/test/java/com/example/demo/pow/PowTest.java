package com.example.demo.pow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {


    Pow pow = new Pow();


    @Test
    void shouldCalculateThePowCorrectly(){
        assertEquals(1024.0, pow.myPow(2, 10));

    }


    @Test
    void shouldCalculateThePowCorrectly2(){
        assertEquals(9.261, pow.myPow(2.1, 3), 0.0001);

    }


    @Test
    void shouldCalculateThePowCorrectly3(){
        assertEquals(4.0, pow.myPow(2.0, 2), 0.0001);

    }


    @Test
    void shouldCalculateThePowCorrectly4(){
        assertEquals(0.25, pow.myPow(2.0, -2), 0.0001);

    }


    @Test
    void shouldCalculateThePowCorrectly5(){
        assertEquals(1.0, pow.myPow(1.0, 2147483647), 0.0001);

    }

    @Test
    void shouldCalculateThePowCorrectly6(){
        assertEquals(0.0, pow.myPow(2.00000, -2147483648), 0.0001);

    }

    @Test
    void shouldCalculateThePowCorrectly7(){
        assertEquals(-1.0, pow.myPow(-1.00000, 2147483647), 0.0001);

    }

    @Test
    void shouldCalculateThePowCorrectly8(){
        assertEquals(1.0, pow.myPow(-1.00000, -2147483648), 0.0001);

    }

}