package com.example.demo.phonenumberletters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void shouldPruneRepeatedPaths(){

        List<String> actualCombinations = phoneNumberLetters.letterCombinations("234");

        List<String> expectedCombinations = List.of("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg",
                "bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi");

        assertEquals(expectedCombinations.size(), actualCombinations.size());
        assertThat(actualCombinations).hasSameElementsAs(expectedCombinations);
    }
}