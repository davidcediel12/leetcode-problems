package com.example.demo.groupanagrams;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();


        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(word);
            } else {
                anagrams.put(key, new ArrayList<>(List.of(word)));
            }
        }
        return anagrams.values().stream().toList();
    }
}
