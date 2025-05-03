package com.example.demo.sudokusolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        List<List<Set<Character>>> subBoxes = new ArrayList<>();
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();

        List<Set<Character>> rowSubBoxes = new ArrayList<>();

        Set<Character> possibleChars = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());
            rows.add(new HashSet<>());
            rowSubBoxes.add(new HashSet<>());

            if ((i + 1) % 3 == 0) {
                subBoxes.add(rowSubBoxes);
                rowSubBoxes = new ArrayList<>();
            }
        }

        completeSudoku(board, rows, cols, subBoxes, possibleChars, 0, 0);


    }


    public void completeSudoku(char[][] board,
                               List<Set<Character>> rows,
                               List<Set<Character>> cols,
                               List<List<Set<Character>>> subBoxes,
                               Set<Character> possibleChars, int row, int col) {


        if(col >= board.length){
            col = 0;
            row++;
        }

        if(row >= board.length){
            return;
        }

        char character = board[row][col];

        Set<Character> existentRowChars = rows.get(row);
        Set<Character> existentColChars = cols.get(col);

        int rowSubBox = row / 3;
        int colSubBox = col / 3;
        Set<Character> existentSubBoxChars = subBoxes.get(rowSubBox).get(colSubBox);

        if (character == '.') {

            for (char c : possibleChars) {
                if (!existentRowChars.contains(c) &&
                        !existentColChars.contains(c) &&
                        !existentSubBoxChars.contains(c)) {

                    board[row][col] = character;
                    var newRows = new ArrayList<>(rows);
                    newRows.get(row).add(c);

                    var newCols = new ArrayList<>(cols);
                    newCols.get(col).add(c);

                    var newSubBoxes = new ArrayList<>(subBoxes);
                    newSubBoxes.get(rowSubBox).get(colSubBox).add(c);

                    completeSudoku(board, rows, cols, subBoxes, possibleChars, row, col+1);
                }
            }
        }
    }
}
