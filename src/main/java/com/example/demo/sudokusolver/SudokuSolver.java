package com.example.demo.sudokusolver;

import java.util.*;

public class SudokuSolver {

    boolean complete = false;

    char[][] finalBoard;

    public void solveSudoku(char[][] board) {

        List<List<Set<Character>>> subBoxes = new ArrayList<>();
        List<Set<Character>> rows = new ArrayList<>();

        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> rowSubBoxes = new ArrayList<>();

        int subBoxCount = 0;
        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());


            rowSubBoxes.add(new HashSet<>());
            subBoxCount++;
            if (subBoxCount >= 3) {
                subBoxes.add(rowSubBoxes);
                rowSubBoxes = new ArrayList<>();
                subBoxCount = 0;
            }
        }


        Set<Character> possibleChars = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            HashSet<Character> row = new HashSet<>();
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                char c = board[rowIndex][colIndex];

                cols.get(colIndex).add(c);
                row.add(c);

                int rowSubBox = rowIndex / 3;
                int colSubBox = colIndex / 3;
                subBoxes.get(rowSubBox).get(colSubBox).add(c);
            }
            rows.add(row);

        }
        completeSudoku(board, rows, cols, subBoxes, possibleChars, 0, 0);
        board = finalBoard;
        System.out.println(Arrays.deepToString(board));
    }


    public void completeSudoku(char[][] board,
                               List<Set<Character>> rows,
                               List<Set<Character>> cols,
                               List<List<Set<Character>>> subBoxes,
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

        Set<Character> existentRowChars = rows.get(row);
        Set<Character> existentColChars = cols.get(col);

        int rowSubBox = row / 3;
        int colSubBox = col / 3;
        Set<Character> existentSubBoxChars = subBoxes.get(rowSubBox).get(colSubBox);


        if (character != '.') {
            completeSudoku(board, rows, cols, subBoxes, possibleChars, row, col + 1);
        } else {

            for (char c : possibleChars) {
                if (!existentRowChars.contains(c) &&
                        !existentColChars.contains(c) &&
                        !existentSubBoxChars.contains(c)) {

                    board[row][col] = c;
                    existentColChars.add(c);
                    existentRowChars.add(c);
                    subBoxes.get(rowSubBox).get(colSubBox).add(c);
                    completeSudoku(board, rows, cols, subBoxes, possibleChars, row, col + 1);

                    if (complete) {
                        return;
                    }

                    board[row][col] = '.';
                    rows.get(row).remove(c);
                    cols.get(col).remove(c);
                    subBoxes.get(rowSubBox).get(colSubBox).remove(c);
                }
            }
        }
    }
}
