package com.example.demo.dividetwointegers;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        int quotient = 0;
        boolean changeSign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor){
            dividend -= divisor;
            quotient++;
        }
        return changeSign ? quotient * -1 : quotient;

    }
}
