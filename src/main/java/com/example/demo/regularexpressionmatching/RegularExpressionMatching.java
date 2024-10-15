package com.example.demo.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return isMatch(s, obtainExpressions(p), 0, 0);
    }

    public boolean isMatch(String s, List<String> expressions,
                           int stringIndex, int expressionIndex) {

        String expression = expressions.get(expressionIndex);

        if (!matches(s.charAt(expressionIndex), expression.charAt(0))) {
            return false;
        }

        boolean lastExpression = expressionIndex == expressions.size() - 1;
        boolean lastWord = stringIndex == s.length() - 1;
        boolean zeroOrMoreCharacters = isZeroOrMoreCharacters(expression);

        if (lastExpression && lastWord) {
            return true;
        } else if (lastExpression && !zeroOrMoreCharacters) {
            return false;
        } else if (zeroOrMoreCharacters && !lastWord) {
            if (lastExpression) {
                return isMatch(s, expressions, stringIndex + 1, expressionIndex);
            } else {
                return isMatch(s, expressions, stringIndex + 1, expressionIndex)
                        || isMatch(s, expressions, stringIndex + 1, expressionIndex + 1);
            }
        } else if (!zeroOrMoreCharacters) {
            return isMatch(s, expressions, stringIndex + 1, expressionIndex + 1);
        } else {
            return false;
        }

    }


    private static List<String> obtainExpressions(String p) {
        List<String> expressions = new ArrayList<>();

        StringBuilder expression = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '.') {
                if (!expression.isEmpty()) {
                    expressions.add(expression.toString());
                }
                expression = new StringBuilder();
                expression.append(c);
            } else if (c == '*') {
                expression.append(c);
                expressions.add(expression.toString());
                expression = new StringBuilder();
            } else {
                expression.append(c);
            }
        }
        if (!expression.isEmpty()) {
            expressions.add(expression.toString());
        }
        return expressions;
    }

    private boolean matches(Character character, Character expectedCharacter) {
        return expectedCharacter.equals('.') || character.equals(expectedCharacter);
    }


    private boolean isZeroOrMoreCharacters(String expression) {
        return expression.endsWith("*");
    }
}
