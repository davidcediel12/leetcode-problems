package com.example.demo.permutations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    Permutations permutations = new Permutations();


    @Test
    void shouldReturnCorrectPermutations() {

        List<List<Integer>> actualPermutations = permutations.permute(new int[]{1, 2, 3});

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

    @Test
    void shouldReturnCorrectPermutations2() {

        List<List<Integer>> actualPermutations = permutations.permute(new int[]{0, 1});

        assertThat(actualPermutations)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        List.of(0, 1),
                        List.of(1, 0)
                ));
    }

    @Test
    void shouldReturnCorrectPermutations3() {

        List<List<Integer>> actualPermutations = permutations.permute(new int[]{1});

        assertThat(actualPermutations)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        List.of(1)
                ));
    }

}