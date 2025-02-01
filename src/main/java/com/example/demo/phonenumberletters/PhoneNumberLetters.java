package com.example.demo.phonenumberletters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetters {

    private static final Map<Character, List<String>> NUMBERS_MAP = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );


    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        return letterCombinations(digits, "", 0);
    }

    private List<String> letterCombinations(String digits,
                                            String combination, int i) {

        List<String> possibleLetters = NUMBERS_MAP.get(digits.charAt(i));

        if (i == digits.length() - 1) {
            return possibleLetters.stream()
                    .map(letter -> combination + letter)
                    .toList();
        }

        List<String> result = new ArrayList<>();
        for (String letter : possibleLetters) {
            result.addAll(letterCombinations(digits, combination + letter, i + 1));
        }

        return result;
    }

}
