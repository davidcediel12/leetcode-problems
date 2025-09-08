package com.example.demo.multiplystrings;

import java.util.Arrays;
import java.util.Map;

public class MultiplyStrings {

    Map<Character, Integer> numbers = Map.of(
            '0', 0,
            '1', 1,
            '2', 2,
            '3', 3,
            '4', 4,
            '5', 5,
            '6', 6,
            '7', 7,
            '8', 8,
            '9', 9
    );

    Map<Long, Character> reversedNumbers = Map.of(
            0L, '0',
            1L, '1',
            2L, '2',
            3L, '3',
            4L, '4',
            5L, '5',
            6L, '6',
            7L, '7',
            8L, '8',
            9L, '9'
    );


    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] digits = new int[num1.length() + num2.length()];

        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {

            for (int j = num2.length() - 1; j >= 0; j--) {

                int result = numbers.get(num1.charAt(i)) * numbers.get(num2.charAt(j));

                digits[i + j + 1] += result + carry;

                digits[i + j + 1] = digits[i + j + 1] % 10;

                carry = digits[i + j + 1] / 10;
            }

        }

        if(carry > 0) {
            digits[0] = digits[0] + carry;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(digits)
                .forEach(sb::append);


        if(sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
