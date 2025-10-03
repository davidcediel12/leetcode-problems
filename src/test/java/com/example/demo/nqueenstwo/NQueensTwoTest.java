package com.example.demo.nqueenstwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTwoTest {

    NQueensTwo nQueensTwo = new NQueensTwo();

    @Test
    void shouldCalculateCorrectlyTheNumberOfSolutions(){
        assertEquals(2, nQueensTwo.totalNQueens(4));
    }

}