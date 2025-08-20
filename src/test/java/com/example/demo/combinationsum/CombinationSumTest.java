package com.example.demo.combinationsum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {

    CombinationSum combinationSum = new CombinationSum();


    @Test
    void shouldReturnCorrectCombinations() {
        List<List<Integer>> options = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);

        List<List<Integer>> expectedOptions = List.of(List.of(2, 2, 3), List.of(7));

        assertThat(options)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedOptions);
    }

    @Test
    void shouldReturnCorrectCombinations2() {
        List<List<Integer>> options = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);

        List<List<Integer>> expectedOptions = List.of(
                List.of(2, 2, 2, 2),
                List.of(2, 3, 3),
                List.of(3, 5));

        assertThat(options)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedOptions);
    }


    @Test
    void shouldReturnCorrectCombinations3() {
        List<List<Integer>> options = combinationSum.combinationSum(new int[]{2}, 1);

        assertThat(options).isEmpty();
    }
}