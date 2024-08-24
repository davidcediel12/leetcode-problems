package com.example.demo;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {

        StringBuilder subString = new StringBuilder();
        int maxLength = 0;
        int length = 0;


        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            boolean containsChar = subString.indexOf(currentChar) >= 0;

            subString.append(currentChar);

            if (containsChar) {
                subString.delete(0, subString.indexOf(currentChar) + 1);
                length = subString.length();
            } else {
                length++;
            }
            if (length > maxLength) {
                maxLength = length;
            }

        }
        return maxLength;
    }


}
