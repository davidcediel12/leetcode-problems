package com.example.demo.longestpalindromicsubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromic {


    public String longestPalindrome(String s) {

        Map<Character, List<Integer>> indexLetters = new HashMap<>();
        String palindrome = "";

        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (indexLetters.containsKey(letter)) {
                for (int index : indexLetters.get(letter)) {
                    String currentSubstring = s.substring(index, i + 1);
                    int subStringLength = 1 + i - index;
                    if (subStringLength > palindrome.length() &&
                            isPalindrome(s, index, i + 1)) {
                        palindrome = currentSubstring;
                    }
                }
                indexLetters.get(letter).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                indexLetters.put(letter, indexes);
                if (palindrome.isEmpty()) {
                    palindrome = String.valueOf(letter);
                }
            }
        }

        return palindrome;
    }


    boolean isPalindrome(String s, int initialIndex, int endIndex) {
        String subString = s.substring(initialIndex, endIndex);
        String reverse = new StringBuilder(subString).reverse().toString();
        return subString.compareTo(reverse) == 0;
    }
}
