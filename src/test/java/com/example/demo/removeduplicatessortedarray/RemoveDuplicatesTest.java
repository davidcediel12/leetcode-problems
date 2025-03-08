package com.example.demo.removeduplicatessortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    RemoveDuplicates removeDuplicates = new RemoveDuplicates();


    @Test
    void shouldRemoveDuplicatesCorrectly() {

        int[] expected = new int[]{1, 2};

        int[] input = new int[]{1, 1, 2};

        int actualK = removeDuplicates.removeDuplicates(input);

        assertCorrectness(actualK, expected, input);
    }

    @Test
    void shouldRemoveDuplicatesCorrectly2() {

        int[] expected = new int[]{0, 1, 2, 3, 4};

        int[] input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int actualK = removeDuplicates.removeDuplicates(input);

        assertCorrectness(actualK, expected, input);
    }


    @Test
    void shouldRemoveDuplicatesCorrectly3() {

        int[] expected = new int[]{0};

        int[] input = new int[]{0,0,0,0,0};

        int actualK = removeDuplicates.removeDuplicates(input);

        assertCorrectness(actualK, expected, input);
    }


    private static void assertCorrectness(int actualK, int[] expected, int[] input) {
        assertEquals(expected.length, actualK);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], input[i]);
        }
    }

}