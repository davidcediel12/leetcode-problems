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


    @Test
    void shouldReturnCorrectIndexes5(){

        List<Integer> actualIndexes = substringWithConcatenation.findSubstring(
                "aaaaaaaaaaaaaa", new String[]{"aa","aa"});

        assertEquals(List.of(0,1,2,3,4,5,6,7,8,9,10), actualIndexes);

    }

}