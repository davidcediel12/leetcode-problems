package com.example.demo.dividetwointegers;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

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

        while (divisorL * Math.pow(2, power + 1D) <= dividendL) {
            power += 1;
        }

        long result = 0;
        long quotient = 0;

        while (power >= 0) {

            long tempResult = result + (divisorL << power);

            if (tempResult <= dividendL) {
                quotient += 1L << power;
                result = tempResult;
            }

            power--;
        }

        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return (int) (0 - quotient);
        }
        return (int) quotient;
    }
}
