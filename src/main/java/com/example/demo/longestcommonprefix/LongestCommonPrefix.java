package com.example.demo.longestcommonprefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix2(String[] strs) {

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


    public String longestCommonPrefix(String[] strs) {

        List<String> stringList = new ArrayList<>(Arrays.stream(strs).toList());

        String minWord = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .orElse("");


        stringList.remove(minWord);

        String bestPrefix = minWord;

        int i = 0;
        while (i < stringList.size()) {

            int j = 0;
            boolean isMatch = true;
            String prefix = "";
            while (j < minWord.length() && isMatch) {
                if (minWord.charAt(j) != stringList.get(i).charAt(j)) {
                    prefix = minWord.substring(0, j);
                    isMatch = false;
                }
                j++;
            }
            if(isMatch){
                prefix = minWord;
            }

            if (prefix.length() < bestPrefix.length()) {
                bestPrefix = prefix;
            }

            i++;
        }
        return bestPrefix;
    }
}
