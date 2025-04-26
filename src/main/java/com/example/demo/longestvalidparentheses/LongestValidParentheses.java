package com.example.demo.longestvalidparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Deque<Character> openParentheses = new ArrayDeque<>();
        int maxLongestValidParentheses = 0;
        int longestValidParentheses = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openParentheses.push(c);
            } else if (openParentheses.isEmpty()) {
                if (longestValidParentheses > maxLongestValidParentheses) {
                    maxLongestValidParentheses = longestValidParentheses;
                }
                longestValidParentheses = 0;
            } else {
                openParentheses.pop();
                longestValidParentheses += 2;
            }
        }

        return Math.max(maxLongestValidParentheses, longestValidParentheses);
    }
}
