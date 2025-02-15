package com.example.demo.generateparentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesesTest {

    GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    void shouldGenerateParenthesesCorrectly() {

        List<String> actualParentheses = generateParentheses.generateParenthesis(3);
        List<String> expectedParentheses = List.of("((()))", "(()())", "(())()", "()(())", "()()()");

        assertThat(actualParentheses)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedParentheses);

    }

}