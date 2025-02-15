package com.example.demo.generateparentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, "", 0, 0);
    }


    private List<String> generateParenthesis(int n, String parentheses, int openParenthesis, int completedPairs) {


        if (openParenthesis + completedPairs == n) {
            List<String> result = new ArrayList<>();
            result.add(parentheses + ")".repeat(openParenthesis));

            return result;
        }

        List<String> resultWithOpening =
                generateParenthesis(n, parentheses + "(", openParenthesis + 1, completedPairs);

        List<String> resultWithClosing = new ArrayList<>();

        if (openParenthesis > 0) {
            resultWithClosing =
                    generateParenthesis(n, parentheses + ")",
                            openParenthesis - 1, completedPairs + 1);
        }

        return Stream.concat(resultWithOpening.stream(), resultWithClosing.stream()).toList();
    }
}
