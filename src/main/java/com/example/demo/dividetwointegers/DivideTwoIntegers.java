package com.example.demo.dividetwointegers;

public class DivideTwoIntegers {
    // TODO FINISH IT
    public int divide2(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        if (dividend == divisor) {
            return 1;
        }

        if (divisor == 1) {
            return dividend;
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

        if ((dividend > 0 && divisor > dividend) || (dividend < 0 && dividend > divisor)) {
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


    public int divide4(int dividend, int divisor) {

        if (noMoreDivision(dividend, divisor)) {
            return 0;
        }

        return divide2(dividend, divisor, 0)
                .times();
    }

    private static int getInitialResult(int dividend, int divisor) {
        int result;
        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }


    public Values divide2(int dividend, int divisor, int times) {


        if (noMoreDivision(dividend, divisor)) {
            return new Values(divisor, times, false);
        }

        times = times != 0 ? times + times : getInitialResult(dividend, divisor);


        Values values = divide2(dividend,
                divisor + divisor,
                times);

        times = values.isPossible ? times + values.times : times;
        int accResult = values.isPossible ? values.accumulatedResult : divisor;

        return new Values(accResult, times, true);
    }

    private static boolean noMoreDivision(int dividend, int divisor) {
        if (divisor == Integer.MAX_VALUE || divisor == Integer.MIN_VALUE) {
            return true;
        }

        if (dividend > 0 && divisor > 0) {
            return divisor > dividend;
        }

        if (dividend < 0 && divisor < 0) {
            return divisor < dividend;
        }

        if (dividend > 0 && divisor < 0) {
            return Math.abs(divisor) > dividend;
        }

        return Math.abs(dividend) > divisor;
    }

    public record Values(int accumulatedResult, int times, boolean isPossible) {
    }


    public int divide(int dividend, int divisor){

        if (dividend == 0) {
            return 0;
        }

        if (dividend == divisor) {
            return 1;
        }

        if (divisor == 1) {
            return dividend;
        }

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);


        int power = 0;

        while(divisorL * Math.pow(2, power + 1D) <= dividendL){
            power += 1;
        }

        long result = 0;
        long quotient = 0;

        while(power >= 0){

            long tempResult = result + (divisorL << power);

            if(tempResult <= dividendL){
                quotient += 1L << power;
                result = tempResult;
            }

            power--;
        }

        if(quotient > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(quotient < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            return (int) (0 - quotient);
        }
        return (int) quotient;
    }
}
