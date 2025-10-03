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

}