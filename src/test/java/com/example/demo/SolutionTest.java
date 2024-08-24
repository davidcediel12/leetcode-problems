package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {


    @Test
    public void test() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list2 = list;

        list2.remove(0);

        System.out.println(list);
        System.out.println(list2);
    }

    @Test
    void testSameNumbers(){
        var solution = new Solution();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{0, 4, 3, 0}, 0)));
    }


    @Test
    void test2(){
        var solution = new Solution();


        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
    }

    @Test
    void test3(){
        var solution = new Solution();


        System.out.println(Arrays.toString(solution.twoSum(new int[]{-3,4,3,90}, 0)));
    }


    @Test
    void test4(){
        var solution = new Solution();


        System.out.println(Arrays.toString(solution.twoSum(new int[]{5,75,25}, 100)));
    }


    @Test
    void test5(){
        var solution = new Solution();


        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 3}, 6)));
    }


    @Test
    void test6(){
        var solution = new Solution();


        System.out.println(Arrays.toString(solution.twoSum(new int[]{1,6142,8192,10239}, 18431)));
    }


}
