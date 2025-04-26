package com.example.demo.searchrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchRotatedSortedArrayTest {


    SearchRotatedSortedArray searcher = new SearchRotatedSortedArray();

    @Test
    void shouldFindCorrectIndex() {
        assertEquals(4, searcher.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }


    @Test
    void shouldFindCorrectIndex2() {
        assertEquals(-1, searcher.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void shouldFindCorrectIndex3() {
        assertEquals(-1, searcher.search(new int[]{1}, 0));
    }

    @Test
    void shouldFindCorrectIndex4() {
        assertEquals(1, searcher.search(new int[]{1, 3}, 3));
    }

    @Test
    void shouldFindCorrectIndex5() {
        assertEquals(0, searcher.search(new int[]{1, 3, 5}, 1));
    }

    @Test
    void shouldFindCorrectIndex6() {
        assertEquals(0, searcher.search(new int[]{5, 1, 3}, 5));
    }

    @Test
    void shouldFindCorrectIndex8() {
        assertEquals(2, searcher.search(new int[]{5, 1, 3}, 3));
    }


    @Test
    void shouldFindCorrectIndex7() {
        assertEquals(2, searcher.search(new int[]{1, 3, 5}, 5));
    }

    @Test
    void shouldFindCorrectIndex9() {
        assertEquals(1, searcher.search(new int[]{5, 1, 2, 3, 4}, 1));
    }


}