package com.example.demo.regularexpressionmatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegularExpressionMatchingTest {

    RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();


    @Test
    void shouldNotMatch() {
        assertFalse(regularExpressionMatching.isMatch("aa", "a"));
    }

    @Test
    void shouldMatchAa() {
        assertTrue(regularExpressionMatching.isMatch("aa", "aa"));
    }


    @Test
    void shouldMatch() {
        assertTrue(regularExpressionMatching.isMatch("aa", "a*"));
    }

    @Test
    void shouldMatchFreeChar() {
        assertTrue(regularExpressionMatching.isMatch("ab", ".*"));
    }

    @Test
    void shouldMatchIgnoringZeroExpressions() {
        assertTrue(regularExpressionMatching.isMatch("aab", "c*a*b"));
    }


    @Test
    void shouldMatchMississippi() {
        assertTrue(regularExpressionMatching.isMatch("mississippi", "mis*is*ip*."));
    }

    @Test
    void shouldNotMatchMississippi() {
        assertFalse(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
    }


    @Test
    void shouldNotMatch2() {
        assertFalse(regularExpressionMatching.isMatch("aaa", "aaaa"));
    }


    @Test
    void shouldMatchADotA() {
        assertTrue(regularExpressionMatching.isMatch("aaa", "a.a"));
    }

    @Test
    void shouldNotMatch3() {
        assertFalse(regularExpressionMatching.isMatch("aaa", "ab*a"));
    }

    @Test
    void shouldMatch3() {
        assertTrue(regularExpressionMatching.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    void shouldMatch4() {
        assertTrue(regularExpressionMatching.isMatch("a", "ab*"));
    }

    @Test
    void shouldMatch5() {
        assertTrue(regularExpressionMatching.isMatch("bbbba", ".*a*a"));
    }

    @Test
    void shouldNotMatch5() {
        assertFalse(regularExpressionMatching.isMatch("aa", ".c*"));
    }


    @Test
    void shouldMatch6() {
        assertTrue(regularExpressionMatching.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));
    }


    @Test
    void shouldMatch7() {
        assertTrue(regularExpressionMatching.isMatch("cbaacacaaccbaabcb", "c*b*b*.*ac*.*bc*a*"));
    }


    @Test
    void shouldNotMatch6() {
        assertFalse(regularExpressionMatching.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*c"));
    }


    @Test
    void shouldNotMatch7() {
        assertTrue(regularExpressionMatching.isMatch("ab", ".*.."));
    }

}