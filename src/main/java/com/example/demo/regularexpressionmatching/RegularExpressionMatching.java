package com.example.demo.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return isMatch(s, obtainExpressions(p), 0, 0, false);
    }

    public boolean isMatch(String s, List<String> expressions,
                           int stringIndex, int expressionIndex, boolean expressionActivated) {

        String expression = expressions.get(expressionIndex);
        boolean zeroOrMoreCharacters = isZeroOrMoreCharacters(expression);
        int expressionLength = getLength(expression, zeroOrMoreCharacters);
        boolean lastExpression = expressionIndex == expressions.size() - 1;


        if (stringIndex + expressionLength > s.length()) {
            return lastExpression && zeroOrMoreCharacters && !expressionActivated;
        }
        String characters = s.substring(stringIndex, stringIndex + expressionLength);
        boolean isMatch = matches(characters, expression);
        boolean lastWord = stringIndex + expressionLength - 1 == s.length() - 1;

        if (!isMatch) {
            if (!zeroOrMoreCharacters || expressionActivated) {
                return false;
            } else if (!lastExpression) {
                return isMatch(s, expressions, stringIndex,
                        expressionIndex + 1, false);
            } else {
                return lastWord;
            }
        }


        if (lastExpression && lastWord) {
            return true;
        } else if (lastExpression && !zeroOrMoreCharacters) {
            return false;
        } else {

            if (zeroOrMoreCharacters && !lastWord) {
                if (lastExpression) {
                    return isMatch(s, expressions, stringIndex + expressionLength,
                            expressionIndex, true);
                } else {
                    return isMatch(s, expressions, stringIndex + expressionLength,
                            expressionIndex, true)
                            || isMatch(s, expressions, stringIndex + expressionLength,
                            expressionIndex + 1, false);
                }
            } else if (!zeroOrMoreCharacters) {
                return isMatch(s, expressions, stringIndex + expressionLength,
                        expressionIndex + 1, false);
            } else {
                return false;
            }
        }

    }

    private static int getLength(String expression, boolean zeroOrMoreCharacters) {
        int length = expression.length();
        if (zeroOrMoreCharacters) {
            length -= 1;
        }
        return length;
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
                if (expression.length() == 1) {
                    expression.append(c);
                    expressions.add(expression.toString());
                } else {
                    int lastWordIdx = expression.length() - 1;
                    expressions.add(expression.substring(0, lastWordIdx));
                    expressions.add(expression.substring(lastWordIdx, expression.length()) + "*");
                }
                expression = new StringBuilder();
            } else if (expression.toString().equals(".")) {
                expressions.add(expression.toString());
                expression = new StringBuilder();
                expression.append(c);
            } else {
                expression.append(c);
            }
        }
        if (!expression.isEmpty()) {
            expressions.add(expression.toString());
        }
        return expressions;
    }

    private boolean matches(String characters, String expression) {
        expression = expression.replace("*", "");
        return expression.equals(".") || expression.equals(characters);
    }


    private boolean isZeroOrMoreCharacters(String expression) {
        return expression.endsWith("*");
    }
}
