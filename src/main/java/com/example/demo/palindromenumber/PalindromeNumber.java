package com.example.demo.palindromenumber;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        int newNumber = 0;
        int originalNumber = x;

        while(x >= 10){
            newNumber = newNumber * 10 + x % 10;
            x = x / 10;
        }
        newNumber = newNumber * 10 + x;
        return newNumber == originalNumber;
    }

}
