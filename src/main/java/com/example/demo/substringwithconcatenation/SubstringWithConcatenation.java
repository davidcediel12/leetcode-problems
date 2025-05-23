package com.example.demo.substringwithconcatenation;

import java.util.*;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> wordsMap = new HashMap<>();
        Arrays.stream(words)
                .forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

        int wordCount = words.length;
        int wordLength = words[0].length();

        Set<Integer> indexes = new HashSet<>();


        for (int startingPoint = 0; startingPoint < wordLength; startingPoint++) {
            addValidIndexesForWindowSize(s, wordsMap, startingPoint, wordLength, indexes, wordCount);

        }

        return indexes.stream().toList();

    }

    private void addValidIndexesForWindowSize(String s, Map<String, Integer> wordsMap,
                                              int startingPoint, int wordLength, Set<Integer> validatedIndexes, int wordCount) {

        Map<Integer, String> wordsAtIndex = new HashMap<>();

        int startingWindowSlice = startingPoint;

        int movingIndex = startingPoint;

        Map<String, Integer> copyWordsMap = new HashMap<>(wordsMap);
        int count = 0;

        while (movingIndex + wordLength <= s.length()) {

            String word = s.substring(movingIndex, movingIndex + wordLength);
            wordsAtIndex.put(movingIndex, word);

            if (copyWordsMap.getOrDefault(word, 0) == 0) {
                boolean isValidWord = wordsMap.containsKey(word);
                if (isValidWord) {
                    while (!wordsAtIndex.get(startingWindowSlice).equals(word)) { // move the sliding window
                        String startingWord = wordsAtIndex.get(startingWindowSlice);
                        copyWordsMap.put(startingWord, copyWordsMap.getOrDefault(startingWord, 0) + 1);
                        startingWindowSlice += wordLength;
                        count--;
                    }
                    startingWindowSlice += wordLength;

                } else { // start again
                    copyWordsMap = new HashMap<>(wordsMap);
                    startingWindowSlice = movingIndex + wordLength;
                    count = 0;
                }
            } else {
                count++;
                int remainingNumberOfThisWord = copyWordsMap.get(word) - 1;

                copyWordsMap.put(word, remainingNumberOfThisWord);

                boolean validSolution = count == wordCount;
                if (validSolution) {
                    validatedIndexes.add(startingWindowSlice);
                    copyWordsMap.put(wordsAtIndex.get(startingWindowSlice), 1);
                    startingWindowSlice += wordLength;
                    count--;
                }
            }
            movingIndex += wordLength;
        }

    }
}
