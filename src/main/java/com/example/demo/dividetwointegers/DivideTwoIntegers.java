package com.example.demo.dividetwointegers;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if(dividend == 0){
            return 0;
        }

        if(dividend == divisor){
            return 1;
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return divideBothSameSign(dividend, divisor);
        }

        if (dividend < 0) {
            return divideDividenNegative(dividend, divisor);
        }

        return divideDivisorNegative(dividend, divisor);
    }

    public int divideBothSameSign(int dividend, int divisor) {

        int quotient = 0;

        if((dividend > 0 && divisor > dividend) || (dividend < 0 && dividend > divisor) ){
            return 0;
        }
        boolean dividendSmaller = dividend <= divisor;

        while (quotient < Integer.MAX_VALUE && ((dividendSmaller && dividend <= divisor) ||
                (!dividendSmaller && dividend >= divisor))) {
            dividend -= divisor;
            quotient++;
        }
        return quotient;

    }

    int divideDividenNegative(int dividend, int divisor) {

        int divisorNegative = -divisor;
        int quotient = 0;
        while (dividend <= divisorNegative) {

            dividend += divisor;
            quotient--;
        }

        return quotient;
    }


    int divideDivisorNegative(int dividend, int divisor) {

        int divisorPositive = -divisor;
        int quotient = 0;

        while (dividend >= divisorPositive) {

            dividend += divisor;
            quotient--;
        }

        return quotient;
    }


}
