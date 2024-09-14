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
}
