package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {


    @Test
    void testSameNumbers(){
        var solution = new Solution();

        int[] actual = solution.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertArrayEquals(new int[]{0, 3}, actual);


    }


    @Test
    void test2(){
        var solution = new Solution();


        int[] actual = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, actual);

    }

    @Test
    void test3(){
        var solution = new Solution();


        int[] actual = solution.twoSum(new int[]{-3,4,3,90}, 0);
        assertArrayEquals(new int[]{0, 2}, actual);

    }


    @Test
    void test4(){
        var solution = new Solution();


        int[] actual = solution.twoSum(new int[]{5,75,25}, 100);
        assertArrayEquals(new int[]{1, 2}, actual);

    }


    @Test
    void test5(){
        var solution = new Solution();


        int[] actual = solution.twoSum(new int[]{3, 2, 3}, 6);
        assertArrayEquals(new int[]{0, 2}, actual);
    }


    @Test
    void test6(){
        var solution = new Solution();


        int[] actual = solution.twoSum(new int[]{1,6142,8192,10239}, 18431);
        assertArrayEquals(new int[]{2, 3}, actual);
    }


}
