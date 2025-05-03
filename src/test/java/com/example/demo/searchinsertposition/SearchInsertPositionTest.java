package com.example.demo.searchinsertposition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    void shouldReturnCorrectIndex(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 5);
        assertEquals(2, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex2(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 2);
        assertEquals(1, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex3(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 7);
        assertEquals(4, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex4(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1, 3}, 0);
        assertEquals(0, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex5(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1, 3}, 2);
        assertEquals(1, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex6(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{1, 3, 5}, 4);
        assertEquals(2, actualIndex);
    }

    @Test
    void shouldReturnCorrectIndex7(){

        int actualIndex = searchInsertPosition.searchInsert(new int[]{3,5,7,9,10}, 8);
        assertEquals(3, actualIndex);
    }

}