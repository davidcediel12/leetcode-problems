package com.example.demo.substringwithconcatenation;

import java.util.*;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        Set<String> wordsSet = new HashSet<>(Arrays.stream(words).toList());
        int wordLength = words[0].length();

        List<Integer> indexes = new ArrayList<>();



        for(int i = 0; i < s.length(); i += wordLength){
            checkConcatenatedString(s, wordsSet, i, wordLength, indexes);
        }

        return indexes;

    }

    private void checkConcatenatedString(String s, Set<String> wordsSet,
                                         int actualIndex, int wordLength, List<Integer> indexes) {

       Set<String> copyWordSet = new HashSet<>(wordsSet);

       int movingIndex = actualIndex;

       while(!copyWordSet.isEmpty() && movingIndex <= s.length()){

           String word = s.substring(movingIndex, movingIndex + wordLength);

           if(!copyWordSet.contains(word)){
               return;
           }

           copyWordSet.remove(word);
           movingIndex += wordLength;
       }

       if(copyWordSet.isEmpty()){
           indexes.add(actualIndex);
       }
    }
}
