package com.example.demo;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {

        String subString = "";
        String result =  "";
        int maxLength = 0;
        int length = 0;


        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            boolean containsChar= subString.contains(currentChar);

            subString = subString + currentChar;

            if (containsChar) {
                subString = subString.substring(subString.indexOf(currentChar) + 1);
                length = subString.length();
            } else {
                length ++;
            }
            if(length > maxLength) {
                result = subString;
                maxLength = length;
            }

        }
        System.out.println("RESULT: " + result);
        return maxLength;
    }


}
