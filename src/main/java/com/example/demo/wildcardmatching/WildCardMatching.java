package com.example.demo.wildcardmatching;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;

public class WildCardMatching {


    public boolean isMatch(String s, String p) {

        Deque<Character> charDequeue = new ArrayDeque<>();

        for (int i = p.length() - 1; i >= 0; i--) {
            charDequeue.push(p.charAt(i));
        }


        return isMatch(charDequeue, s);
    }


    private boolean isMatch(Queue<Character> pattern, String s) {

        if (s.isEmpty() && containsJustWildCards(pattern)) {
            return true;
        }

        if (pattern.isEmpty()) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        Character actualPattern = pattern.peek();

        if (!matches(actualPattern, s)) {
            return false;
        }

        String newString = s.substring(1);
        Deque<Character> newPattern = new ArrayDeque<>(pattern);
        newPattern.pop();

        if (actualPattern.equals('*')) {

            return isMatch(newPattern, newString) || isMatch(pattern, newString) ||
                    isMatch(newPattern, s);
        }

        return isMatch(newPattern, newString);


    }

    private static boolean containsJustWildCards(Queue<Character> pattern) {
        return pattern.stream()
                .allMatch(c -> c.equals('*'));
    }

    private boolean matches(Character actualPattern, String s) {

        return actualPattern.equals('*') ||
                (actualPattern.equals('?') && !s.isEmpty()) ||
                (!s.isEmpty() && Objects.equals(actualPattern, s.charAt(0)));
    }
}
