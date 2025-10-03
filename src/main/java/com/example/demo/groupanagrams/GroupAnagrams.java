package com.example.demo.groupanagrams;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();


        for (String word : strs) {

            String key = Arrays.stream(word.split("")).sorted().collect(Collectors.joining());

            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(word);
            } else {
                anagrams.put(key, new ArrayList<>(List.of(word)));
            }
        }
        return anagrams.values().stream().toList();
    }
}
