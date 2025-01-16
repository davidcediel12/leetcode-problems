package com.example.demo.longestcommonprefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();


    @Test
    void shouldObtainPrefixCorrectly(){

        String obtainedPrefix = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});

        assertEquals("fl", obtainedPrefix);
    }


    @Test
    void shouldReturnEmptyPrefix(){

        String obtainedPrefix = longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"});

        assertEquals("", obtainedPrefix);
    }


    @Test
    void shouldReturnCompleteWordWhenArrayContainsUniqueValue(){

        String obtainedPrefix = longestCommonPrefix.longestCommonPrefix(new String[]{"a"});

        assertEquals("a", obtainedPrefix);
    }

}