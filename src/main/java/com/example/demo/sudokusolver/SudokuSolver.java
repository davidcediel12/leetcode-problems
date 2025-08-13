package com.example.demo.sudokusolver;

import java.util.Arrays;
import java.util.Set;

public class SudokuSolver {

    boolean complete = false;

    char[][] finalBoard;

    public void solveSudoku(char[][] board) {

        Set<Character> possibleChars = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

        completeSudoku(board, possibleChars, 0, 0);
        board = finalBoard;
        System.out.println(Arrays.deepToString(board));
    }


    public void completeSudoku(char[][] board,
                               Set<Character> possibleChars, int row, int col) {


        if (col >= board.length) {
            col = 0;
            row++;
        }

        if (row >= board.length) {
            complete = true;
            finalBoard = board;
            return;
        }

        char character = board[row][col];


        if (character != '.') {
            completeSudoku(board, possibleChars, row, col + 1);
        } else {

            for (char c : possibleChars) {
                if (isNumberValid(c, row, col, board)) {

                    board[row][col] = c;
                    completeSudoku(board, possibleChars, row, col + 1);

                    if (complete) {
                        return;
                    }

                    board[row][col] = '.';
                }
            }
        }
    }

    private static boolean isNumberValid(char c,
                                         int row, int col,
                                         char[][] board) {


        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }

        }
        int initSubBoxRow = (row / 3) * 3;
        int initSubBoxCol = (col / 3) * 3;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (board[j + initSubBoxRow][k + initSubBoxCol] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
