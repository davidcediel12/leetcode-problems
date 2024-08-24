package com.example.demo;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {

        String subString = "";
        StringBuilder potentialSubString = new StringBuilder();
        int maxLength = 0;
        int length = 0;


        for (int init = 0; init < s.length(); init++) {
            if (maxLength > (s.length() - init) + length) {
                return maxLength;
            }

            boolean repeatedChar = false;
            int window = init;
            length = 0;

            while (!repeatedChar && window < s.length()) {
                char c = s.charAt(window);
                if (potentialSubString.toString().contains(String.valueOf(c))) {
                    repeatedChar = true;

                    potentialSubString = new StringBuilder();

                } else {
                    length++;
                    potentialSubString.append(c);
                }

                if (length > maxLength) {
                    subString = potentialSubString.toString();
                    maxLength = length;
                }

                window++;
            }
        }
        System.out.println(subString);
        return Math.max(maxLength, length);
    }


}
