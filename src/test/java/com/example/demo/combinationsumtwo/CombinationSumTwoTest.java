package com.example.demo.combinationsumtwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTwoTest {


    CombinationSumTwo combinationSumTwo = new CombinationSumTwo();


    @Test
    void shouldReturnCorrectOptions() {

        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};

        List<List<Integer>> expectedOptions = List.of(
                List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6)
        );

        var actualOptions = combinationSumTwo.combinationSum2(candidates, 8);

        assertThat(actualOptions)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedOptions);
    }


    @Test
    void shouldReturnCorrectOptions2() {

        int[] candidates = new int[]{2, 5, 2, 1, 2};

        List<List<Integer>> expectedOptions = List.of(
                List.of(1, 2, 2),
                List.of(5)
        );

        var actualOptions = combinationSumTwo.combinationSum2(candidates, 5);

        assertThat(actualOptions)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedOptions);
    }


    @Test
    void shouldReturnCorrectOptions3() {

        int[] candidates = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        List<Integer> uniqueSolution = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            uniqueSolution.add(1);
        }

        List<List<Integer>> expectedOptions = List.of(
                uniqueSolution
        );

        var actualOptions = combinationSumTwo.combinationSum2(candidates, 30);

        assertThat(actualOptions)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedOptions);
    }

}