package com.example.demo.jumpgametwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTwoTest {


    JumpGameTwo jumpGameTwo = new JumpGameTwo();


    @Test
    void shouldReturnCorrectJumps() {

        assertEquals(2, jumpGameTwo.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    void shouldReturnCorrectJumps2() {

        assertEquals(2, jumpGameTwo.jump(new int[]{2, 3, 0, 1, 4}));
    }

    @Test
    void shouldReturnCorrectJumps3(){

        assertEquals(5, jumpGameTwo.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }

}