package com.example.demo.permutationstwo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTwoTest {

    PermutationsTwo permutationsTwo = new PermutationsTwo();


    @Test
    void shouldCreatePermutationsCorrectly() {
        List<List<Integer>> actualPermutations = permutationsTwo.permuteUnique(new int[]{1, 1, 2});

        assertThat(actualPermutations)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        List.of(1, 1, 2),
                        List.of(1, 2, 1),
                        List.of(2, 1, 1)
                ));
    }

    @Test
    void shouldReturnCorrectPermutations() {

        List<List<Integer>> actualPermutations = permutationsTwo.permuteUnique(new int[]{1, 2, 3});

        assertThat(actualPermutations)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 3),
                        List.of(2, 3, 1),
                        List.of(3, 1, 2),
                        List.of(3, 2, 1)
                ));
    }

}