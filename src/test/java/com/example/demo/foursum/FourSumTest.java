package com.example.demo.foursum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FourSumTest {

    FourSum fourSum = new FourSum();


    @Test
    void shouldReturnQuadrupletsCorrectly() {
        var actualQuadruplets = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        var expectedQuadruplets = List.of(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        );

        assertThat(actualQuadruplets)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedQuadruplets);
    }

}