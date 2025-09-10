package com.example.demo.wildcardmatching;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class WildCardMatching {


    public boolean isMatch(String s, String p) {

        Queue<Character> charQueue = new ArrayDeque<>();

        for (int i = p.length() - 1; i >= 0; i--) {
            charQueue.add(p.charAt(i));
        }


        return isMatch(charQueue, s);
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
        Queue<Character> newPattern = new ArrayDeque<>(pattern);

        if (actualPattern.equals('*')) {
            newPattern.poll();

            return isMatch(newPattern, newString) || isMatch(pattern, newString);
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
