package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {
    
    TwoSum twoSum = new TwoSum();

    @Test
    void testSameNumbers(){
        int[] actual = twoSum.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertArrayEquals(new int[]{0, 3}, actual);


    }


    @Test
    void test2(){
        int[] actual = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, actual);

    }

    @Test
    void test3(){
        int[] actual = twoSum.twoSum(new int[]{-3,4,3,90}, 0);
        Assertions.assertThat(actual).containsExactlyInAnyOrder(0, 2);

    }


    @Test
    void test4(){
        int[] actual = twoSum.twoSum(new int[]{5,75,25}, 100);
        Assertions.assertThat(actual).containsExactlyInAnyOrder(1, 2);

    }


    @Test
    void test5(){
        int[] actual = twoSum.twoSum(new int[]{3, 2, 3}, 6);
        Assertions.assertThat(actual).containsExactlyInAnyOrder(0, 2);
    }


    @Test
    void test6(){
        int[] actual = twoSum.twoSum(new int[]{1,6142,8192,10239}, 18431);
        Assertions.assertThat(actual).containsExactlyInAnyOrder(2, 3);
    }


}
