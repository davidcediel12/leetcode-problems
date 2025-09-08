package com.example.demo.multiplystrings;

import java.util.Map;

public class MultiplyStrings {


    Map<Character, Long> numbers = Map.of(
            '0', 0L,
            '1', 1L,
            '2', 2L,
            '3', 3L,
            '4', 4L,
            '5', 5L,
            '6', 6L,
            '7', 7L,
            '8', 8L,
            '9', 9L
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


        Long result = transform(num1) * transform(num2);

        StringBuilder sb = new StringBuilder();

        while (result / 10 > 0){
            sb.insert(0, result % 10);
            result = result / 10;
        }
        sb.insert(0, result);
        return sb.toString();

    }


    private Long transform(String num){

        int count = 0;
        Long transformedNum = 0L;

        for (int i = num.length() - 1; i >= 0; i--) {

            Character c = num.charAt(i);
            Long digit = numbers.get(c);
            transformedNum += digit * (long) Math.pow(10, count);
            count++;
        }

        return transformedNum;
    }
}
