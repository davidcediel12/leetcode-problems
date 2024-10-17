package com.example.demo.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {

    Boolean[][] results;
    String s;
    List<String> expressions;

    public boolean isMatch(String s, String p) {
        obtainExpressions(p);
        results = new Boolean[s.length()][expressions.size()];
        this.s = s;

        return isMatch(0, 0, false);
    }

    public boolean isMatch(int stringIndex, int expressionIndex, boolean expressionActivated) {


        String expression = expressions.get(expressionIndex);
        boolean zeroOrMoreCharacters = isZeroOrMoreCharacters(expression);
        int expressionLength = getLength(expression, zeroOrMoreCharacters);
        boolean lastExpression = expressionIndex == expressions.size() - 1;


        if (stringIndex + expressionLength > s.length()) {
            return lastExpression && zeroOrMoreCharacters && !expressionActivated;
        }

        if (results[stringIndex][expressionIndex] != null) {
            return results[stringIndex][expressionIndex];
        }

        String characters = s.substring(stringIndex, stringIndex + expressionLength);
        boolean isMatch = matches(characters, expression);
        boolean lastWord = stringIndex + expressionLength - 1 == s.length() - 1;

        if (!isMatch) {
            if (!zeroOrMoreCharacters || expressionActivated || lastExpression) {
                results[stringIndex][expressionIndex] = false;
                return false;
            } else {
                results[stringIndex][expressionIndex] = isMatch(stringIndex, expressionIndex + 1, false);
                return results[stringIndex][expressionIndex];
            }
        }

        return handleExpressionMatch(stringIndex, expressionIndex, lastExpression, lastWord, zeroOrMoreCharacters, expressionLength);

    }

    private boolean handleExpressionMatch(int stringIndex, int expressionIndex, boolean lastExpression,
                                          boolean lastWord, boolean zeroOrMoreCharacters, int expressionLength) {
        if (lastExpression && lastWord) {
            results[stringIndex][expressionIndex] = true;
            return true;
        } else if (lastExpression && !zeroOrMoreCharacters) {
            results[stringIndex][expressionIndex] = false;
            return false;
        } else {
            boolean allRemainingExpressionsAreOptional = expressions.subList(expressionIndex + 1, expressions.size())
                    .stream().allMatch(this::isZeroOrMoreCharacters);

            if (zeroOrMoreCharacters) {
                manageMatchWithZeroOrMoreCharactersExpression(
                        stringIndex, expressionIndex,
                        lastExpression, expressionLength, lastWord, allRemainingExpressionsAreOptional);
            } else {
                results[stringIndex][expressionIndex] = (lastWord && allRemainingExpressionsAreOptional) ||
                        isMatch(stringIndex + expressionLength, expressionIndex + 1, false);
            }
            return results[stringIndex][expressionIndex];
        }
    }

    private void manageMatchWithZeroOrMoreCharactersExpression(int stringIndex,
                                                               int expressionIndex, boolean lastExpression,
                                                               int expressionLength, boolean lastWord,
                                                               boolean allRemainingExpressionsAreOptional) {
        if (lastExpression) {
            results[stringIndex][expressionIndex] = isMatch(stringIndex + expressionLength,
                    expressionIndex, true);
        } else {
            if (lastWord) {
                results[stringIndex][expressionIndex] = allRemainingExpressionsAreOptional ||
                        isMatch(stringIndex, expressionIndex + 1, false);
            } else {
                results[stringIndex][expressionIndex] =
                        isMatch(stringIndex, expressionIndex + 1, false) ||
                                isMatch(stringIndex + expressionLength, expressionIndex, true) ||
                                isMatch(stringIndex + expressionLength, expressionIndex + 1, false);
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


    private void obtainExpressions(String p) {
        expressions = new ArrayList<>();

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
    }

    private boolean matches(String characters, String expression) {
        expression = expression.replace("*", "");
        return expression.equals(".") || expression.equals(characters);
    }


    private boolean isZeroOrMoreCharacters(String expression) {
        return expression.endsWith("*");
    }
}
