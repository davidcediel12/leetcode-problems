package com.example.demo.trappingrainwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    TrappingRainWater trappingRainWater = new TrappingRainWater();


    @Test
    void shouldCalculateTrappingWaterCorrectly(){

        int actualWater = trappingRainWater.trap(new int[]{4, 2, 0, 3, 2, 5});

        assertEquals(9, actualWater);

    }


    @Test
    void shouldCalculateTrappingWaterCorrectly2(){

        int actualWater = trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

        assertEquals(6, actualWater);

    }


    @Test
    void shouldCalculateTrappingWaterCorrectly3(){

        int actualWater = trappingRainWater.trap(new int[]{2, 0, 2});

        assertEquals(2, actualWater);

    }
}