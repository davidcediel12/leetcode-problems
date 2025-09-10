package com.example.demo.wildcardmatching;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WildCardMatching {

    Map<String, Boolean> pastMatches = new HashMap<>();

    public boolean isMatch(String s, String p) {

        if (pastMatches.containsKey(p + "-" + s)) {
            return pastMatches.get(p + "-" + s);
        }

        if (s.isEmpty() && containsJustWildCards(p)) {
            addMatch(p, s, true);
            return true;
        }

        if (p.isEmpty()) {
            addMatch(p, s, false);
            return false;
        }

        if (s.isEmpty()) {
            addMatch(p, s, false);
            return false;
        }


        int firstWildcardIdx = getFirstWildcardIdx(p);


        String newString;
        String newPattern;


        if (firstWildcardIdx < 0) {
            return p.equals(s);
        }


        boolean match;

        if (firstWildcardIdx == 0) {

            Character actualPattern = p.charAt(0);

            if (!matches(actualPattern, s)) {
                addMatch(p, s, false);
                return false;
            }

            newString = s.substring(1);
            newPattern = p.substring(1);


            if (actualPattern.equals('*')) {

                match = isMatch(newString, newPattern) || isMatch(newString, p) ||
                        isMatch(s, newPattern);

            } else {
                match = isMatch(newString, newPattern);
            }

        } else {
            if (s.length() - 1 < firstWildcardIdx ||
                    !s.substring(0, firstWildcardIdx).equals(p.substring(0, firstWildcardIdx))) {
                addMatch(p, s, false);
                return false;
            }
            newString = s.substring(firstWildcardIdx);
            newPattern = p.substring(firstWildcardIdx);


            match = isMatch(newString, newPattern);
        }

        addMatch(p, s, match);
        return match;


    }

    private static int getFirstWildcardIdx(String p) {
        int firstWildcardIdx = p.indexOf("*");
        int firstQuestionIdx = p.indexOf("?");

        if (firstWildcardIdx < 0) {
            firstWildcardIdx = firstQuestionIdx;
        } else if (firstQuestionIdx >= 0) {
            firstWildcardIdx = Math.min(firstQuestionIdx, firstWildcardIdx);
        }
        return firstWildcardIdx;
    }

    private static boolean containsJustWildCards(String pattern) {
        return pattern.matches("\\**");
    }

    private boolean matches(Character actualPattern, String s) {

        return actualPattern.equals('*') ||
                (actualPattern.equals('?') && !s.isEmpty()) ||
                (!s.isEmpty() && Objects.equals(actualPattern, s.charAt(0)));
    }


    private void addMatch(String pattern, String s, boolean result) {
        pastMatches.put(pattern + "-" + s, result);
    }
}