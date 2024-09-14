package com.example.demo.stringtointeger;

public class StringToInteger {

    public int myAtoi(String s) {

        s = s.trim();
        boolean isNegative = false;
        boolean numberStarted = false;

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Integer.parseInt(Character.toString(c));

                if (number > Integer.MAX_VALUE / 10 || number * 10 > Integer.MAX_VALUE - digit) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                number = (number * 10) + digit;
                numberStarted = true;
            } else if (c == '-' && !numberStarted) {
                isNegative = true;
                numberStarted = true;
            } else if (c == '+' && !numberStarted) {
                numberStarted = true;
            } else if (isNegative) {
                return number * -1;
            } else {
                return number;
            }
        }

        if (isNegative) {
            return number * -1;
        }

        return number;
    }
}
