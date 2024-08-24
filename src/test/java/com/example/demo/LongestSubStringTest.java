package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubStringTest {

    LongestSubString longestSubString = new LongestSubString();

    @Test
    void test1(){
        assertEquals(3, longestSubString.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void shouldReturnOneWhenAllLettersAreTheSame(){
        assertEquals(1, longestSubString.lengthOfLongestSubstring("bbbbb"));
    }


    @Test
    void shouldReturnZeroWhenStringIsEmpty(){
        assertEquals(0, longestSubString.lengthOfLongestSubstring(""));
    }

    @Test
    void shouldReturnOneWhenStringIsSpace(){
        assertEquals(1, longestSubString.lengthOfLongestSubstring(" "));
    }

    @Test
    void test4(){
        assertEquals(3, longestSubString.lengthOfLongestSubstring("dvdf"));
    }
}
