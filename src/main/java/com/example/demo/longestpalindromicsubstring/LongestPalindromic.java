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
                boolean foundPalindrome = false;
                int j = 0;
                while (j < indexLetters.get(letter).size() && !foundPalindrome) {
                    int index = indexLetters.get(letter).get(j);
                    String currentSubstring = s.substring(index, i + 1);
                    int subStringLength = 1 + i - index;

                    if(subStringLength <= palindrome.length()){
                        foundPalindrome = true;
                    } else if (isPalindrome(s, index, i + 1)) {
                        foundPalindrome = true;
                        palindrome = currentSubstring;
                    }
                    j += 1;
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
