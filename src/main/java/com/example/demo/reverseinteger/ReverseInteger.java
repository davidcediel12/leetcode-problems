package com.example.demo.reverseinteger;

public class ReverseInteger {


    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean isNegative = s.charAt(0) == '-';

        StringBuilder sb = new StringBuilder(s);

        try {
            if (isNegative) {
                sb.deleteCharAt(0);
                return -1 * Integer.valueOf(sb.reverse().toString());
            } else {
                return Integer.valueOf(sb.reverse().toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }

    }


    public int reverse2(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x = x * -1;
        }

        int number = 0;
        while (x >= 10) {
            int b = x % 10;
            if (tooBig(number, b)) {
                return 0;
            }
            number = (number * 10) + b;
            x = x / 10;
        }


        if (tooBig(number, x)) {
            return 0;
        }
        number = (number * 10) + x;


        if (isNegative) {
            return number * -1;
        }

        return number;
    }

    boolean tooBig(int number, int x) {
        return number > Integer.MAX_VALUE / 10 || number * 10 > Integer.MAX_VALUE - x;
    }
}
