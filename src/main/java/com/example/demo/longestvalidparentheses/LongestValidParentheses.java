package com.example.demo.longestvalidparentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Deque<Character> openParentheses = new ArrayDeque<>();
        int maxLongestValidParentheses = 0;
        int longestValidParentheses = 0;

        List<Integer> pastResults = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openParentheses.push(c);
                if (i > 0 && s.charAt(i - 1) == '(') {
                    pastResults.add(longestValidParentheses);
                    longestValidParentheses = 0;
                }
            } else if (openParentheses.isEmpty()) {
                if(longestValidParentheses > maxLongestValidParentheses){
                    maxLongestValidParentheses = longestValidParentheses;
                }
                longestValidParentheses = 0;
            } else {
                openParentheses.pop();
                longestValidParentheses += 2;
                if (i > 0 && s.charAt(i - 1) == ')'){
                    longestValidParentheses += pastResults.removeLast();
                }
            }
        }
        return Math.max(longestValidParentheses, maxLongestValidParentheses);
    }
}
