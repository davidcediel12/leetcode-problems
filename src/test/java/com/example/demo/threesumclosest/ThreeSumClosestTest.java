package com.example.demo.threesumclosest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumClosestTest {

    ThreeSumClosest threeSumClosest = new ThreeSumClosest();

    @Test
    void shouldFindThreeSumEqualToTwo(){
        int closestSum = threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1);

        assertEquals(2, closestSum);
    }

    @Test
    void shouldFindThreeSumEqualToZero(){
        int closestSum = threeSumClosest.threeSumClosest(new int[]{0,0,0}, 1);

        assertEquals(0, closestSum);
    }

    @Test
    void shouldFindThreeSumEqualToMinusTwo(){
        int closestSum = threeSumClosest.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);

        assertEquals(-2, closestSum);
    }

}