package com.example.demo.nqueens;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NQueensTest {


    NQueens nQueens = new NQueens();


    @Test
    void shouldReturnNQueensSolutionsCorrectly() {

        List<List<String>> expectedSolution = List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q..")
        );

        assertThat(nQueens.solveNQueens(4))
                .usingRecursiveComparison()
                .isEqualTo(expectedSolution);

    }


    @Test
    void shouldReturnNQueensSolutionsCorrectly2() {

        List<List<String>> expectedSolution = List.of(
                List.of("Q")
        );

        assertThat(nQueens.solveNQueens(1))
                .usingRecursiveComparison()
                .isEqualTo(expectedSolution);

    }
}