package com.example.demo.nqueenstwo;

import java.util.ArrayList;
import java.util.List;

public class NQueensTwo {


    private int solutions = 0;
    private final List<List<String>> board = new ArrayList<>();

    public int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            List<String> boardRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                boardRow.add(".");
            }
            board.add(boardRow);
        }

        boolean[] forbiddenCols = new boolean[n];


        nQueens(0, forbiddenCols);

        return solutions;

    }


    private void nQueens(int row, boolean[] forbiddenCols) {

        if (row >= board.size()) {
            solutions++;
        }

        for (int i = 0; i < board.size(); i++) {

            if (!forbiddenCols[i]) {

                forbiddenCols[i] = true;
                board.get(row).set(i, "Q");

                if (isValidBoard(board, row, i)) {
                    nQueens(row + 1, forbiddenCols);
                }

                board.get(row).set(i, ".");
                forbiddenCols[i] = false;
            }
        }
    }

    private boolean isValidBoard(List<List<String>> board, int row, int col) {

        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board.get(i).get(j).equals("Q")) {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < board.size()) {
            if (board.get(i).get(j).equals("Q")) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}
