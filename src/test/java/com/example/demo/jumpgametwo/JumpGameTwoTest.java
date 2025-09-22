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

}