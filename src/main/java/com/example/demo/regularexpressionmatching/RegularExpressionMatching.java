package com.example.demo.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {

    Boolean[][] results;

    public boolean isMatch(String s, String p) {
        List<String> expressions = obtainExpressions(p);
        results = new Boolean[s.length()][expressions.size()];

        return isMatch(s, expressions, 0, 0, false);
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
                return isMatch(s, expressions, stringIndex,
                        expressionIndex + 1, false);
            }
        }


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
                if (lastExpression) {
                    return isMatch(s, expressions, stringIndex + expressionLength,
                            expressionIndex, true);
                } else {
                    if (lastWord) {
                        results[stringIndex][expressionIndex] = allRemainingExpressionsAreOptional ||
                                isMatch(s, expressions, stringIndex, expressionIndex + 1, false);
                        return results[stringIndex][expressionIndex];
                    } else {
                        results[stringIndex][expressionIndex] = isMatch(s, expressions, stringIndex, expressionIndex + 1, false) ||
                                isMatch(s, expressions, stringIndex + expressionLength,
                                        expressionIndex, true) ||
                                isMatch(s, expressions, stringIndex + expressionLength,
                                        expressionIndex + 1, false);
                        return results[stringIndex][expressionIndex];
                    }
                }
            } else {
                results[stringIndex][expressionIndex] = (lastWord && allRemainingExpressionsAreOptional) ||
                        isMatch(s, expressions, stringIndex + expressionLength,
                                expressionIndex + 1, false);
                return results[stringIndex][expressionIndex];
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
