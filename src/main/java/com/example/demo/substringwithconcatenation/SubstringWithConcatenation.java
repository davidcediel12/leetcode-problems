package com.example.demo.substringwithconcatenation;

import java.util.*;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> wordsMap = new HashMap<>();
        Arrays.stream(words)
                .forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

        int wordLength = words[0].length();

        List<Integer> indexes = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            boolean isValidString = checkConcatenatedString(s, wordsMap, i, wordLength);

            if (isValidString) {
                indexes.add(i);
            }
        }

        return indexes;

    }

    private boolean checkConcatenatedString(String s, Map<String, Integer> wordsMap,
                                            int actualIndex, int wordLength) {


        Map<String, Integer> copyWordsMap = new HashMap<>(wordsMap);
        int movingIndex = actualIndex;

        while (!copyWordsMap.isEmpty() && movingIndex <= s.length() && movingIndex + wordLength <= s.length()) {

            String word = s.substring(movingIndex, movingIndex + wordLength);

            if (copyWordsMap.getOrDefault(word, 0) == 0) {
                return false;
            }

            int remainingNumberOfThisWord = copyWordsMap.get(word) - 1;
            if (remainingNumberOfThisWord > 0) {
                copyWordsMap.put(word, remainingNumberOfThisWord);
            } else {
                copyWordsMap.remove(word);
            }
            movingIndex += wordLength;
        }

        return copyWordsMap.isEmpty();
    }
}
