package com.example.demo.rotateimage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateImageTest {


    RotateImage rotateImage = new RotateImage();


    @Test
    void shouldRotateCorrectly() {

        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        int[][] expectedRotation = new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        };

        rotateImage.rotate(matrix);

        assertThat(matrix)
                .isEqualTo(expectedRotation);
    }

    @Test
    void shouldRotateCorrectly2() {

        int[][] matrix = new int[][]{
                new int[]{5,1,9,11},
                new int[]{2,4,8,10},
                new int[]{13,3,6,7},
                new int[]{15,14,12,16}
        };

        int[][] expectedRotation = new int[][]{
                new int[]{15,13,2,5},
                new int[]{14,3,4,1},
                new int[]{12,6,8,9},
                new int[]{16,7,10,11}
        };

        rotateImage.rotate(matrix);

        assertThat(matrix)
                .isEqualTo(expectedRotation);
    }

}