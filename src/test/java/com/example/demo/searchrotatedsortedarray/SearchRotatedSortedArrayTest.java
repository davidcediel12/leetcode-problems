package com.example.demo.searchrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRotatedSortedArrayTest {


    SearchRotatedSortedArray searcher = new SearchRotatedSortedArray();

    @Test
    void shouldFindCorrectIndex(){
        assertEquals(4, searcher.search(new int[]{4,5,6,7,0,1,2}, 0));
    }


    @Test
    void shouldFindCorrectIndex2(){
        assertEquals(-1, searcher.search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    @Test
    void shouldFindCorrectIndex3(){
        assertEquals(-1, searcher.search(new int[]{1}, 0));
    }

}