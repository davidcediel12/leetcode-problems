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


    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] digits = new int[num1.length() + num2.length()];


        int[] carries = new int[num1.length() + num2.length()];


        for (int i = num2.length() - 1; i >= 0; i--) {

            for (int j = num1.length() - 1; j >= 0; j--) {

                int result = digits[i + j + 1] +
                        numbers.get(num2.charAt(i)) * numbers.get(num1.charAt(j)) + carries[i+j+1];


                carries[i + j + 1] = 0;



                digits[i + j + 1] = result % 10;

                carries[i + j] += result / 10;
            }

        }

        if(carries[0] > 0) {
            digits[0] = digits[0] + carries[0];
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
