package com.example.demo.integertoroman;

public class IntegerToRoman {


    public String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();


        while (num > 0) {
            Value value = obtainValue(num);
            if (value.canReduceMultiple()) {
                int digit = Integer.parseInt(String.valueOf(num).substring(0, 1));

                roman.append(value.roman().repeat(digit));
                num -= (value.number() * digit);
            } else {
                roman.append(value.roman());
                num -= value.number();
            }

        }

        return roman.toString();

    }


    private Value obtainValue(int num) {

        if (num >= 1000) return new Value(1000, "M", true);
        if (num >= 900) return new Value(900, "CM", false);
        if (num >= 500) return new Value(500, "D", false);
        if (num >= 400) return new Value(400, "CD", false);
        if (num >= 100) return new Value(100, "C", true);
        if (num >= 90) return new Value(90, "XC", false);
        if (num >= 50) return new Value(50, "L", false);
        if (num >= 40) return new Value(40, "XL", false);
        if (num >= 10) return new Value(10, "X", true);
        if (num >= 9) return new Value(9, "IX", false);
        if (num >= 5) return new Value(5, "V", false);
        if (num >= 4) return new Value(4, "IV", false);
        return new Value(1, "I", true);
    }

    record Value(Integer number, String roman, boolean canReduceMultiple) {
    }

}
