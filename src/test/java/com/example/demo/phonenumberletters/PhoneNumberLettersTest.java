package com.example.demo.phonenumberletters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberLettersTest {

    PhoneNumberLetters phoneNumberLetters = new PhoneNumberLetters();


    @Test
    void shouldReturnCombinationsCorrectly(){

        List<String> actualCombinations = phoneNumberLetters.letterCombinations("23");
        List<String> expectedCombinations = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");

        assertEquals(expectedCombinations, actualCombinations);
    }


    @Test
    void shouldReturnEmptyCombinations(){

        List<String> actualCombinations = phoneNumberLetters.letterCombinations("");

        assertTrue(actualCombinations.isEmpty());
    }
}