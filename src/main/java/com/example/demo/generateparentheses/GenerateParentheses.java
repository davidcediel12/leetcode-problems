package com.example.demo.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", 0, 0, result);
        return result;
    }


    private void generateParenthesis(int n, String parentheses, int openParenthesis, int completedPairs,
                                     List<String> result) {


        if (openParenthesis + completedPairs == n) {
            result.add(parentheses + ")".repeat(openParenthesis));

            return;
        }


        generateParenthesis(n, parentheses + "(", openParenthesis + 1, completedPairs, result);

        if (openParenthesis > 0) {
            generateParenthesis(n, parentheses + ")",
                    openParenthesis - 1, completedPairs + 1, result);
        }
    }
}
