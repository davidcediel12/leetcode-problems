package com.example.demo.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {


    public boolean isMatch(String s, String p) {

        List<String> expressions = obtainExpressions(p);

        Integer currentIndex = 0;

        int i = 0;
        while (i < expressions.size()) {
            String expressionRule = expressions.get(i);
            String analyzed = s.substring(currentIndex);

            if (isFreeCharacters(expressionRule)) {
                char cardinality = expressionRule.charAt(1);


                if (i + 1 < expressions.size()) {
                    String nextExpression = expressions.get(i + 1);
                    boolean isFreeExpression = isFreeCharacters(nextExpression);

                    if (isFreeExpression && cardinality == '+') {
                        currentIndex += 1;
                    } else if (!isFreeExpression) {

                        int reservedCharacters = cardinality == '+' ? 1 : 0;

                        int nextExpressionIdx = analyzed.indexOf(nextExpression, reservedCharacters);

                        if (nextExpressionIdx < 0) {
                            return false;
                        }
                        currentIndex += reservedCharacters + nextExpressionIdx + nextExpression.length();
                        i++;
                    }
                } else if (cardinality == '+') {
                    return currentIndex < s.length();
                } else {
                    return true;
                }
            } else {
                if (!analyzed.startsWith(expressionRule)) {
                    return false;
                }
                currentIndex += expressionRule.length();
            }
            i++;
        }

        return currentIndex.equals(s.length());
    }

    private static List<String> obtainExpressions(String p) {
        List<String> expressions = new ArrayList<>();

        StringBuilder expression = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '.') {
                expressions.add(expression.toString());
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




    private boolean isFreeCharacters(String expressionRule) {
        return expressionRule.startsWith(".");
    }
}
