package com.example.demo.validsudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<List<Set<Character>>> subBoxes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Set<Character>> rowSubBoxes = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                rowSubBoxes.add(new HashSet<>());
            }
            subBoxes.add(rowSubBoxes);
        }

        List<Set<Character>> rows = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
        }
        List<Set<Character>> cols = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                char character = board[row][col];

                if (character == '.') {
                    continue;
                }

                if (rows.get(row).contains(character)) {
                    return false;
                }
                rows.get(row).add(character);


                if (cols.get(col).contains(character)) {
                    return false;
                }
                cols.get(col).add(character);

                int rowSubBox = row / 3;
                int colSubBox = col / 3;
                if (subBoxes.get(rowSubBox).get(colSubBox).contains(character)) {
                    return false;
                }
                subBoxes.get(rowSubBox).get(colSubBox).add(character);
            }
        }
        return true;

    }
}
