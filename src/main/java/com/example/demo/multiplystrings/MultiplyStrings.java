package com.example.demo.multiplystrings;

import java.math.BigDecimal;
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


        BigDecimal result = BigDecimal.valueOf(transform(num1)) .multiply(BigDecimal.valueOf(transform(num2)));

        StringBuilder sb = new StringBuilder();

        while (result.compareTo(BigDecimal.TEN) >= 0){
            BigDecimal[] divideAndRemainder = result.divideAndRemainder(BigDecimal.TEN);
            sb.insert(0, divideAndRemainder[1].intValue());
            result = divideAndRemainder[0];
        }
        if(result.compareTo(BigDecimal.ZERO) > 0) {
            sb.insert(0, result.intValue());
        }
        return sb.toString();

    }


    private Double transform(String num){

        int count = 0;
        Double transformedNum = 0D;

        for (int i = num.length() - 1; i >= 0; i--) {

            Character c = num.charAt(i);
            Long digit = numbers.get(c);
            transformedNum += digit *  Math.pow(10, count);
            count++;
        }

        return transformedNum;
    }
}
