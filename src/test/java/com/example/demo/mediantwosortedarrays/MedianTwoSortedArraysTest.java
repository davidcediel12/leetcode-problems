package com.example.demo.mediantwosortedarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTwoSortedArraysTest {

    MedianTwoSortedArrays extractor = new MedianTwoSortedArrays();


    @Test
    void shouldReturnMidNumberIfLengthIsImpair(){
        double median = extractor.findMedianSortedArrays(new int[]{1,3}, new int[]{2});

        assertEquals(2.0, median);
    }

    @Test
    void shouldReturnSumOfNumbersIfLengthIsPair(){
        double median = extractor.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4});

        assertEquals(2.5, median);
    }

    @Test
    void shouldReturnUniqueNumberIfThereIsOnlyOneNumber(){
        double median = extractor.findMedianSortedArrays(new int[]{}, new int[]{1});

        assertEquals(1, median);
    }


    @Test
    void test(){
        double median = extractor.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7});

        assertEquals(2.5, median);
    }

    @Test
    void shouldIgnoreFirstArrayIfIsEmpty(){
        double median = extractor.findMedianSortedArrays(new int[]{}, new int[]{2, 3});

        assertEquals(2.5, median);
    }

    @Test
    void shouldIgnoreSecondArrayIfIsEmpty(){
        double median = extractor.findMedianSortedArrays(new int[]{3, 4}, new int[]{});

        assertEquals(3.5, median);
    }

    @Test
    void test2(){
        double median = extractor.findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 4, 4});

        assertEquals(3.0, median);
    }

}
