package com.example.demo.substringwithconcatenation;

import java.util.*;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        List<String> wordList = Arrays.asList(words);
        int wordLength = words[0].length();

        List<Integer> indexes = new ArrayList<>();



        for(int i = 0; i < s.length(); i += wordLength){
            checkConcatenatedString(s, wordList, i, wordLength, indexes);
        }

        return indexes;

    }

    private void checkConcatenatedString(String s, List<String> wordList,
                                         int actualIndex, int wordLength, List<Integer> indexes) {


        List<String> copyWordList = new ArrayList<>(wordList);
       int movingIndex = actualIndex;

       while(!copyWordList.isEmpty() && movingIndex <= s.length() && movingIndex + wordLength <= s.length()){

           String word = s.substring(movingIndex, movingIndex + wordLength);

           if(!copyWordList.contains(word)){
               return;
           }

           copyWordList.remove(word);
           movingIndex += wordLength;
       }

       if(copyWordList.isEmpty()){
           indexes.add(actualIndex);
       }
    }
}
