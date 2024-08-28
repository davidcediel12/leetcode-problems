package com.example.demo.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicTest {

    LongestPalindromic longestPalindromic = new LongestPalindromic();

    @Test
    void shouldReturnStringWithThreeChars(){
        String result = longestPalindromic.longestPalindrome("babad");
        assertEquals(3, result.length());
        assertEquals("bab", result);
    }

    @Test
    void shouldReturnStringWithTwoChars(){
        String result = longestPalindromic.longestPalindrome("cbbd");
        assertEquals(2, result.length());
        assertEquals("bb", result);
    }

    @Test
    void shouldReturnUniqueCharacterWhenStringOnlyContainsOne(){
        String result = longestPalindromic.longestPalindrome("a");
        assertEquals(1, result.length());
        assertEquals("a", result);
    }

    @Test
    void shouldReturnUniqueCharacterWhenStringDoesntContainsPalindroms(){
        String result = longestPalindromic.longestPalindrome("ac");
        assertEquals(1, result.length());
        assertEquals("a", result);
    }

}