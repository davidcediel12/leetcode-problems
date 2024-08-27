package com.example.demo.mediantwosortedarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTwoSortedArraysTest {

    MedianTwoSortedArrays extractor = new MedianTwoSortedArrays();


    @Test
    void shouldReturnMidNumberIfLengthItsPair(){
        double median = extractor.findMedianSortedArrays(new int[]{1,3}, new int[]{2});

        assertEquals(2.0, median);
    }

    @Test
    void shouldReturnMidNumberIfLengthItsImpair(){
        double median = extractor.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4});

        assertEquals(2.5, median);
    }
}
