package com.example.demo.removeelement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    RemoveElement removeElement = new RemoveElement();

    @Test
    void shouldRemoveAllK(){
        int[] input = new int[]{3, 2, 2, 3};

        int[] expected = new int[]{2, 2};

        int k = removeElement.removeElement(input, 3);

        assertEquals(expected.length, k);

        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], input[i]);
        }
    }

}