package com.example.demo.longestcommonprefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix1(String[] strs) {

        String minWord = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        String commonPrefix = "";
        boolean isPrefix = true;
        int i = 1;

        while (isPrefix && i <= minWord.length()) {

            String prefix = minWord.substring(0, i);

            isPrefix = Arrays.stream(strs)
                    .parallel()
                    .allMatch(str -> str.startsWith(prefix));


            if (isPrefix) {
                commonPrefix = prefix;
            }
            i++;

        }

        return commonPrefix;
    }


    public String longestCommonPrefix2(String[] strs) {

        List<String> stringList = new ArrayList<>(Arrays.stream(strs).toList());

        String firstWord = stringList.getFirst();

        stringList.removeFirst();

        String bestPrefix = firstWord;

        int i = 0;
        while (i < stringList.size() && !bestPrefix.isEmpty()) {

            int j = 0;
            boolean isMatch = true;
            String prefix = "";
            String currentWord = stringList.get(i);
            while (j < firstWord.length() && j < currentWord.length() && isMatch) {
                if (firstWord.charAt(j) != currentWord.charAt(j)) {
                    prefix = firstWord.substring(0, j);
                    isMatch = false;
                }
                j++;
            }
            if (isMatch) {
                if (firstWord.length() < currentWord.length()) {
                    prefix = firstWord;
                } else {
                    prefix = currentWord;
                }
            }

            if (prefix.length() < bestPrefix.length()) {
                bestPrefix = prefix;
            }

            i++;
        }
        return bestPrefix;
    }


    public String longestCommonPrefix(String[] strs) {

        List<String> stringList = Arrays.stream(strs).sorted().toList();

        String firstWord = stringList.getFirst();
        String lastWord = stringList.getLast();

        int i = 0;

        while (i < firstWord.length() && i < lastWord.length()) {
            if (firstWord.charAt(i) != lastWord.charAt(i)) {
                return firstWord.substring(0, i);
            }
            i ++;
        }

        return firstWord;
    }
}
