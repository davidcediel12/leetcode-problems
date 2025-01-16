package com.example.demo.romantointeger;

import java.util.Map;

public class RomanToInteger {

    private static final  Map<String, Integer> SUBTRACTED_NUMBERS = Map.of(
            "CM", 900,
            "CD", 400,
            "XC", 90,
            "XL", 40,
            "IX", 9,
            "IV", 4
    );

    private static final Map<String, Integer> NUMBERS = Map.of(
            "M", 1000,
            "D", 500,
            "C", 100,
            "L", 50,
            "X", 10,
            "V", 5,
            "I", 1
    );

    public int romanToInt(String s) {

        int num = 0;

        while (!s.isEmpty()) {

            String section = s.substring(0, Math.min(2, s.length()));
            boolean isSubtracted;
            int value;

            if(SUBTRACTED_NUMBERS.containsKey(section)){
                value = SUBTRACTED_NUMBERS.get(section);
                isSubtracted = true;
            } else {
                section = section.substring(0, 1);
                value = NUMBERS.get(section);
                isSubtracted = false;
            }

            num += value;
            if (isSubtracted) {
                s = s.substring(2);
            } else {
                s = s.substring(1);
            }
        }
        return num;
    }
}
