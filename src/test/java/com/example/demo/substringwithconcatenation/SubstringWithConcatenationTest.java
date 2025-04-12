package com.example.demo.substringwithconcatenation;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstringWithConcatenationTest {

    SubstringWithConcatenation substringWithConcatenation = new SubstringWithConcatenation();

    @Test
    void shouldReturnCorrectIndexes(){

        List<Integer> actualIndexes = substringWithConcatenation.findSubstring(
                "barfoothefoobarman", new String[]{"foo","bar"});

        assertEquals(List.of(0, 9), actualIndexes);

    }

    @Test
    void shouldReturnCorrectIndexes2(){

        List<Integer> actualIndexes = substringWithConcatenation.findSubstring(
                "wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});

        assertEquals(Collections.emptyList(), actualIndexes);

    }

    @Test
    void shouldReturnCorrectIndexes3(){

        List<Integer> actualIndexes = substringWithConcatenation.findSubstring(
                "barfoofoobarthefoobarman", new String[]{"bar","foo","the"});

        assertEquals(List.of(6, 9, 12), actualIndexes);

    }

    @Test
    void shouldReturnCorrectIndexes4(){

        List<Integer> actualIndexes = substringWithConcatenation.findSubstring(
                "lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});

        assertEquals(List.of(13), actualIndexes);

    }

}