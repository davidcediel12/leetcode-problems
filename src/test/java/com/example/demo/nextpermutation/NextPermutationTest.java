package com.example.demo.nextpermutation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPermutationTest {

    NextPermutation nextPermutation = new NextPermutation();

    @Test
    void shouldObtainNextPermutation() {

        int[] actualNums = nextPermutation.obtainNextPermutation(new int[]{1, 2, 3});

        assertThat(actualNums)
                .containsExactly(1, 3, 2);
    }

    @Test
    void shouldObtainNextPermutation2() {

        int[] actualNums = nextPermutation.obtainNextPermutation(new int[]{1, 1, 5});

        assertThat(actualNums)
                .containsExactly(1, 5, 1);
    }


    @Test
    void shouldObtainNextPermutation3() {

        int[] actualNums = nextPermutation.obtainNextPermutation(new int[]{3, 2, 1});

        assertThat(actualNums)
                .containsExactly(1, 2, 3);
    }

    @Test
    void shouldObtainNextPermutation4() {

        int[] actualNums = nextPermutation.obtainNextPermutation(new int[]{4, 8, 5, 2});

        assertThat(actualNums)
                .containsExactly(5, 2, 4, 8);
    }
}