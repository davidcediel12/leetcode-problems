package com.example.demo.substringwithconcatenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        List<String> wordList = Arrays.asList(words);
        int wordLength = words[0].length();

        List<Integer> indexes = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            boolean isValidString = checkConcatenatedString(s, wordList, i, wordLength);

            if (isValidString) {
                indexes.add(i);
            }
        }

        return indexes;

    }

    private boolean checkConcatenatedString(String s, List<String> wordList,
                                            int actualIndex, int wordLength) {


        List<String> copyWordList = new ArrayList<>(wordList);
        int movingIndex = actualIndex;

        while (!copyWordList.isEmpty() && movingIndex <= s.length() && movingIndex + wordLength <= s.length()) {

            String word = s.substring(movingIndex, movingIndex + wordLength);

            if (!copyWordList.contains(word)) {
                return false;
            }

            copyWordList.remove(word);
            movingIndex += wordLength;
        }

        return copyWordList.isEmpty();
    }
}
