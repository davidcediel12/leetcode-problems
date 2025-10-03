package com.example.demo.pow;

public class Pow {

    public double myPow(double x, int n) {

        double result = 1;

        if(n == 0 || x == 1){
            return 1D;
        }

        if(x == 0D){
            return 0D;
        }

        boolean isNegative = n < 0;
        if(isNegative){
            n = n * -1;
        }

        while(n > 0){
            result = result * x;
            n--;
        }

        if(isNegative){
            return 1/result;
        }
        return result;
    }
}
