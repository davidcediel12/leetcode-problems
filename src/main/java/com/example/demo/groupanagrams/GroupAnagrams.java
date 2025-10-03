package com.example.demo.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> anagrams = new ArrayList<>();


        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            boolean added = false;
            int j = 0;

            while (!added && j < anagrams.size()) {

                String existingWord = anagrams.get(j).stream().findFirst().get();

                if (existingWord.length() != word.length()) {
                    j++;
                    continue;
                }

                List<String> charsExisting = Arrays.stream(existingWord.split(""))
                        .sorted()
                        .toList();

                List<String> charsWord = Arrays.stream(word.split(""))
                        .sorted()
                        .toList();

                if (Objects.equals(charsExisting, charsWord)) {
                    anagrams.get(j).add(word);
                    added = true;
                }
                j++;
            }

            if (!added) {
                anagrams.add(new ArrayList<>(List.of(word)));
            }
        }
        return anagrams;
    }
}
