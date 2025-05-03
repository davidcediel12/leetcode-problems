package com.example.demo.validsudoku;

import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> subBoxes = HashMap.newHashMap(9);
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);

        for (int row = 0; row < board.length; row++) {
            if (rows.size() <= row + 1) {
                rows.add(new HashSet<>());
            }
            for (int col = 0; col < board[row].length; col++) {

                if (cols.size() <= col + 1) {
                    cols.add(new HashSet<>());
                }

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

                String key = obtainSubBox(row, col);

                subBoxes.putIfAbsent(key, new HashSet<>());
                if (subBoxes.get(key).contains(character)) {
                    return false;
                }
                subBoxes.get(key).add(character);
            }
        }
        return true;

    }

    private String obtainSubBox(int row, int col) {
        return (row / 3) + ":" + (col / 3);
    }
}
