package com.example.demo.validparentheses;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();

        Map<Character, Character> opensForClosings = Map.of(
                ']', '[',
                ')', '(',
                '}', '{'
        );

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                parentheses.add(c);
            } else if (parentheses.isEmpty()) {
                return false;
            } else {
                char expectedOpeningInStack = opensForClosings.get(c);
                Character actualOpening = parentheses.pop();

                if (!actualOpening.equals(expectedOpeningInStack)) {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }
}
