package com.example.demo.palindromenumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    PalindromeNumber palindromeNumber = new PalindromeNumber();

    @Test
    void shouldReturnTrue(){
        assertTrue(palindromeNumber.isPalindrome(121));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, -121})
    void shouldReturnFalse(Integer n){
        assertFalse(palindromeNumber.isPalindrome(n));
    }

}