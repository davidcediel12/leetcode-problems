package com.example.demo.pow;

public class Pow {

    static class InefficientSolution {
        public double myPow(double x, int n) {

            double result = 1;

            if (n == 0 || x == 1) {
                return 1D;
            }

            if (x == 0D || (n == Integer.MIN_VALUE && x != -1)) {
                return 0D;
            }

            if (x == -1D) {
                if (n % 2 == 0) {
                    return 1D;
                }
                return -1D;
            }

            boolean isNegative = n < 0;
            if (isNegative) {
                n = n * -1;
            }

            while (n > 0) {
                result = result * x;
                n--;
            }

            if (isNegative) {
                return 1 / result;
            }
            return result;
        }
    }


    public double myPow(double x, int n) {

        if (n == 0 || x == 1D) {
            return 1D;
        }

        if (x == 0D || (n == Integer.MIN_VALUE && x != -1)) {
            return 0D;
        }


        if (x == -1D) {
            if (n % 2 == 0) {
                return 1D;
            }
            return -1D;
        }

        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }

        return x * myPow(x * x, (n - 1) / 2);
    }
}
