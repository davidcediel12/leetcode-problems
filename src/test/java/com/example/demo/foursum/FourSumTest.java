package com.example.demo.foursum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void shouldReturnQuadrupletsCorrectly2() {
        var actualQuadruplets = fourSum.fourSum(new int[]{2, 2, 2, 2}, 8);

        var expectedQuadruplets = List.of(
                List.of(2, 2, 2, 2)
        );

        assertEquals(expectedQuadruplets, actualQuadruplets);
    }

    @Test
    void shouldReturnQuadrupletsCorrectly3() {
        var actualQuadruplets = fourSum.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0);

        var expectedQuadruplets = List.of(
                List.of(-3, -1, 0, 4)
        );

        assertEquals(expectedQuadruplets.size(), actualQuadruplets.size());

        assertThat(actualQuadruplets.getFirst()).hasSameElementsAs(expectedQuadruplets.getFirst());
    }

    @Test
    void shouldReturnQuadrupletsCorrectly4() {
        var actualQuadruplets = fourSum.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 2);

        var expectedQuadruplets = List.of(
                List.of(-3, -1, 2, 4)
        );

        assertEquals(expectedQuadruplets.size(), actualQuadruplets.size());

        assertThat(actualQuadruplets.getFirst()).hasSameElementsAs(expectedQuadruplets.getFirst());
    }

    @Test
    void shouldPruneRepeatedResults() {
        var actualQuadruplets = fourSum.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);

        var expectedQuadruplets = List.of(
                List.of(-2, -1, 1, 2),
                List.of(-1, -1, 1, 1)
        );

        assertThat(actualQuadruplets)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedQuadruplets);
    }

    @Test
    void shouldReturnEmptyQuadruplets() {
        var actualQuadruplets = fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);


        assertThat(actualQuadruplets).isEmpty();
    }

}