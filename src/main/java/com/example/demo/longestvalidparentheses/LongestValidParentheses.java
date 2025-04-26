package com.example.demo.longestvalidparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Deque<Character> openParentheses = new ArrayDeque<>();
        int maxLongestValidParentheses = 0;
        int longestValidParentheses = 0;

        Deque<Integer> pastResults = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openParentheses.push(c);
                if (i > 0 && s.charAt(i - 1) == '(') {
                    pastResults.push(longestValidParentheses);
                    maxLongestValidParentheses = Math.max(longestValidParentheses, maxLongestValidParentheses);
                    longestValidParentheses = 0;
                }
            } else if (openParentheses.isEmpty()) {
                maxLongestValidParentheses = Math.max(longestValidParentheses, maxLongestValidParentheses);
                longestValidParentheses = 0;
            } else {
                openParentheses.pop();
                longestValidParentheses += 2;
                if (s.charAt(i - 1) == ')') {
                    longestValidParentheses += pastResults.pop();
                }
            }
        }
        return Math.max(longestValidParentheses, maxLongestValidParentheses);
    }
}
