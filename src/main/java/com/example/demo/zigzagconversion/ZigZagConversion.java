package com.example.demo.zigzagconversion;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {



    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int actualRow = 1;
        boolean directionDown = true;

        Map<Integer, StringBuilder> stringPerRow = new HashMap<>();
        for(int i = 0; i < s.length(); i++){

            if(stringPerRow.containsKey(actualRow)){
                stringPerRow.get(actualRow).append(s.charAt(i));
            } else {
                stringPerRow.put(actualRow, new StringBuilder(String.valueOf(s.charAt(i))));
            }

            if(actualRow >= numRows){
                directionDown = false;
            } else if (actualRow == 1) {
                directionDown = true;
            }

            if(directionDown) {
                actualRow += 1;
            } else{
                actualRow -= 1;
            }
        }

        StringBuilder completeWord = new StringBuilder();
        for(int i = 1; i <= numRows; i++){
            completeWord.append(stringPerRow.getOrDefault(i, new StringBuilder()));
        }

        return completeWord.toString();
    }
}
