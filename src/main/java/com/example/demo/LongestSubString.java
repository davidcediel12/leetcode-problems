package com.example.demo;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {

        String subString = "";
        StringBuilder potentialSubString = new StringBuilder();
        int maxLength = 0;
        int length = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(potentialSubString.toString().contains(String.valueOf(c))){
                if(length > maxLength){
                    subString = potentialSubString.toString();
                    potentialSubString = new StringBuilder(String.valueOf(s.charAt(i)));
                    maxLength = length;
                }

                length = 1;

            } else {
                length++;
                potentialSubString.append(c);
            }
        }
        System.out.println(subString);
        return Math.max(maxLength, length);
    }



}
