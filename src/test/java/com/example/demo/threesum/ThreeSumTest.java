package com.example.demo.threesum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    ThreeSum threeSum = new ThreeSum();

    @Test
    void shouldCreateTripletsCorrectly(){

        List<List<Integer>> returnedTriplets = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});

        List<List<Integer>> expectedTriplets = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );

        assertEquals(expectedTriplets.size(), returnedTriplets.size());

        returnedTriplets.forEach(returnedTriplet ->
                assertTrue(expectedTriplets.stream()
                        .anyMatch(expectedTriplet -> expectedTriplet.containsAll(returnedTriplet))));
    }


    @Test
    void whenThereIsNoValidTripletShouldReturnEmptyList(){

        List<List<Integer>> returnedTriplets = threeSum.threeSum(new int[]{-1,0,2});

        assertThat(returnedTriplets).isEmpty();
    }


    @Test
    void shouldCreateTripletsCorrectly2(){

        List<List<Integer>> returnedTriplets = threeSum.threeSum(new int[]{
                -15,6,7,0,-14,-5,-3,-10,-14,1,-14,-1,-11,-11,-15,-1,3,-12,7,14,1,6,-6,7,1,1,0,-4,8,7,
                2,1,-2,-6,-14,-9,-3,-1,-12,-2,7,11,4,12,-14,-4,-4,4,-1,10,3,-14,1,12,0,10,-9,8,-9,14,
                -8,8,0,-3,10,-6,4,-8,0,-1,-3,-8,-4,8,11,-3,-11,-8,8,3,10,-3,-4,-4,-14,12,13,-8,-3,12,
                -8,4,5,-1,-14,-8,8,-3,-9,-15,12,-5,-7,-15,-12,11,-11,14,11,12,3,6,-6});

        List<List<Integer>> expectedTriplets = List.of(
                List.of(-15,1,14), List.of(-15,2,13),
                List.of(-15,3,12), List.of(-15,4,11),
                List.of(-15,5,10), List.of(-15,7,8),
                List.of(-14,0,14), List.of(-14,1,13),
                List.of(-14,2,12), List.of(-14,3,11),
                List.of(-14,4,10), List.of(-14,6,8),
                List.of(-14,7,7), List.of(-12,-2,14),
                List.of(-12,-1,13), List.of(-12,0,12),
                List.of(-12,1,11), List.of(-12,2,10),
                List.of(-12,4,8), List.of(-12,5,7),
                List.of(-12,6,6), List.of(-11,-3,14),
                List.of(-11,-2,13), List.of(-11,-1,12),
                List.of(-11,0,11), List.of(-11,1,10),
                List.of(-11,3,8), List.of(-11,4,7),
                List.of(-11,5,6), List.of(-10,-4,14),
                List.of(-10,-3,13), List.of(-10,-2,12),
                List.of(-10,-1,11), List.of(-10,0,10),
                List.of(-10,2,8), List.of(-10,3,7),
                List.of(-10,4,6), List.of(-9,-5,14),
                List.of(-9,-4,13), List.of(-9,-3,12),
                List.of(-9,-2,11), List.of(-9,-1,10),
                List.of(-9,1,8), List.of(-9,2,7),
                List.of(-9,3,6), List.of(-9,4,5),
                List.of(-8,-6,14), List.of(-8,-5,13),
                List.of(-8,-4,12), List.of(-8,-3,11),
                List.of(-8,-2,10), List.of(-8,0,8),
                List.of(-8,1,7), List.of(-8,2,6),
                List.of(-8,3,5), List.of(-8,4,4),
                List.of(-7,-6,13), List.of(-7,-5,12),
                List.of(-7,-4,11), List.of(-7,-3,10),
                List.of(-7,-1,8), List.of(-7,0,7),
                List.of(-7,1,6), List.of(-7,2,5),
                List.of(-7,3,4), List.of(-6,-6,12),
                List.of(-6,-5,11), List.of(-6,-4,10),
                List.of(-6,-2,8), List.of(-6,-1,7),
                List.of(-6,0,6), List.of(-6,1,5),
                List.of(-6,2,4), List.of(-6,3,3),
                List.of(-5,-5,10), List.of(-5,-3,8),
                List.of(-5,-2,7), List.of(-5,-1,6),
                List.of(-5,0,5), List.of(-5,1,4),
                List.of(-5,2,3), List.of(-4,-4,8),
                List.of(-4,-3,7), List.of(-4,-2,6),
                List.of(-4,-1,5), List.of(-4,0,4),
                List.of(-4,1,3), List.of(-3,-3,6),
                List.of(-3,-2,5), List.of(-3,-1,4),
                List.of(-3,0,3), List.of(-3,1,2),
                List.of(-2,-2,4), List.of(-2,-1,3),
                List.of(-2,0,2), List.of(-2,1,1),
                List.of(-1,-1,2), List.of(-1,0,1), List.of(0,0,0)
        );

        assertEquals(expectedTriplets.size(), returnedTriplets.size());

        returnedTriplets.forEach(returnedTriplet ->
                assertTrue(expectedTriplets.stream()
                        .anyMatch(expectedTriplet -> expectedTriplet.containsAll(returnedTriplet))));
    }





}