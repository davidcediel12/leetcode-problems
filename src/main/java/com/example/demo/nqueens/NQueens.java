package com.example.demo.nqueens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    private List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> boardRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                boardRow.add(".");
            }
            board.add(boardRow);
        }

        nQueens(board, 0, new HashSet<>());

        return solutions;

    }


    private void nQueens(List<List<String>> board, int row, Set<Integer> forbiddenCols) {

        if (row >= board.size()) {
            List<String> solution = new ArrayList<>();

            board.forEach(boardRow -> solution.add(String.join("", boardRow)));

            solutions.add(solution);
        }

        for (int i = 0; i < board.size(); i++) {

            if (!forbiddenCols.contains(i)) {

                forbiddenCols.add(i);
                board.get(row).set(i, "Q");

                if (isValidBoard(board, row, i)) {
                    nQueens(board, row + 1, forbiddenCols);
                }

                board.get(row).set(i, ".");
                forbiddenCols.remove(i);
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
