package com.example.demo.longestcommonprefix;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

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
}
