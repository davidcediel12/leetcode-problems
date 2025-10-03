package com.example.demo.groupanagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagramsTest {

    GroupAnagrams groupAnagrams = new GroupAnagrams();


    @Test
    void shouldGroupAnagramsCorrectly() {
        var actualGroup = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});


        var expectedGroup = List.of(
                List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );


        assertThat(actualGroup)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedGroup);
    }


    @Test
    void shouldReturnEmptyGroup() {
        var actualGroup = groupAnagrams.groupAnagrams(new String[]{""});


        var expectedGroup = List.of(
                List.of("")
        );


        assertThat(actualGroup)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedGroup);
    }

}