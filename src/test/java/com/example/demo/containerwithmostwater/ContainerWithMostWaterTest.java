package com.example.demo.containerwithmostwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    void shouldReturn49(){
        int result = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

        assertEquals(49, result);
    }

    @Test
    void shouldReturn1(){
        int result = containerWithMostWater.maxArea(new int[]{1, 1});

        assertEquals(1, result);
    }

}