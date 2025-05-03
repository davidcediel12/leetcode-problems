package com.example.demo.firstlastpositionsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstLastPositionSortedArrayTest {

    FirstLastPositionSortedArray searcher = new FirstLastPositionSortedArray();


    @Test
    void shouldFindCorrectIndexes(){

        var result = searcher.searchRange(new int[]{5,7,7,8,8,10}, 8);

        assertEquals(3, result[0]);
        assertEquals(4, result[1]);
    }


    @Test
    void shouldFindCorrectIndexes2(){

        var result = searcher.searchRange(new int[]{5,7,7,8,8,10}, 6);

        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }


    @Test
    void shouldFindCorrectIndexes3(){

        var result = searcher.searchRange(new int[]{}, 0);

        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

}