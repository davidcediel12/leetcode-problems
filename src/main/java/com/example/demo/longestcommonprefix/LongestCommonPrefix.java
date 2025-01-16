package com.example.demo.longestcommonprefix;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String firstWord = strs[0];

        String commonPrefix = "";
        boolean isPrefix = true;
        int i = 1;

        while(isPrefix && i <= firstWord.length()){

            String prefix = firstWord.substring(0, i);

            isPrefix = Arrays.stream(strs)
                    .parallel()
                    .allMatch(str -> str.startsWith(prefix));


            if(isPrefix) {
                commonPrefix = prefix;
            }
            i++;

        }
        return commonPrefix;
    }
}
