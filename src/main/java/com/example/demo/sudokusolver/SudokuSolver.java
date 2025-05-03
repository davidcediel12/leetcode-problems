package com.example.demo.sudokusolver;

import java.util.*;

public class SudokuSolver {

    boolean complete = false;

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


        if (col >= board.length) {
            col = 0;
            row++;
        }

        if (row == 8) {
            System.out.println("row: " + row + " col: " + col);
        }
        if(row ==8 && col ==8){
            System.out.println("great!");
        }
        if (row >= board.length) {
            complete = true;
            return;
        }

        char character = board[row][col];

        Set<Character> existentRowChars = rows.get(row);
        Set<Character> existentColChars = cols.get(col);

        int rowSubBox = row / 3;
        int colSubBox = col / 3;
        Set<Character> existentSubBoxChars = subBoxes.get(rowSubBox).get(colSubBox);

        Set<Character> charsToChoose;
        if (character == '.') {
            charsToChoose = possibleChars;
        } else {
            charsToChoose = Set.of(character);
        }
        for (char c : charsToChoose) {
            if (!existentRowChars.contains(c) &&
                    !existentColChars.contains(c) &&
                    !existentSubBoxChars.contains(c)) {

                char[][] newBoard = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
                newBoard[row][col] = c;

                List<Set<Character>> newRows = new ArrayList<>();

                rows.forEach(eachRow -> newRows.add(new HashSet<>(eachRow)));

                newRows.get(row).add(c);

                List<Set<Character>> newCols = new ArrayList<>();

                cols.forEach(eachCol -> newCols.add(new HashSet<>(eachCol)));

                newCols.get(col).add(c);

                List<List<Set<Character>>> newSubBoxes = new ArrayList<>();
                subBoxes.forEach(rowSubBoxes -> {
                    List<Set<Character>> newSubBox = new ArrayList<>();
                    rowSubBoxes.forEach(subBox -> newSubBox.add(new HashSet<>(subBox)));
                    newSubBoxes.add(new ArrayList<>(newSubBox));
                });
                newSubBoxes.get(rowSubBox).get(colSubBox).add(c);

                completeSudoku(newBoard, newRows, newCols, newSubBoxes, possibleChars, row, col + 1);
                if (complete) {
                    return;
                }
                if (row == 8) {
                    System.out.println("almost complete");
                }
            }
        }
    }
}
