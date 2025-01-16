package com.example.demo.integertoroman;

import java.util.List;

public class IntegerToRoman {

    record Value(Integer number, String roman) {
    }

    public String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();

        List<Value> values = List.of(
                new Value(1000, "M"),
                new Value(900, "CM"),
                new Value(500, "D"),
                new Value(400, "CD"),
                new Value(100, "C"),
                new Value(90, "XC"),
                new Value(50, "L"),
                new Value(40, "XL"),
                new Value(10, "X"),
                new Value(9, "IX"),
                new Value(5, "V"),
                new Value(4, "IV"),
                new Value(1, "I")
        );

        for(Value value : values) {
            while (num >= value.number()) {
                roman.append(value.roman());
                num -= value.number();
            }
        }

        return roman.toString();

    }

}
