package com.example.demo.combinationsum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    Set<List<Integer>> alreadyCheckedOptions = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> options = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, new ArrayList<>(), options);
        return options;
    }


    private void combinationSum(int[] candidates, int target, int actualNumber, int i,
                                List<Integer> option,
                                List<List<Integer>> options){

        if(i == candidates.length || actualNumber > target){
            return;
        }



        if(actualNumber == target){
            options.add(option);
            return;
        }


        var option1 = new ArrayList<>(option);
        option1.add(candidates[i]);
        if(!alreadyCheckedOptions.contains(option1)) {
            alreadyCheckedOptions.add(option1);
            combinationSum(candidates, target, actualNumber + candidates[i], i, new ArrayList<>(option1), options);
        }

        if(i + 1 < candidates.length) {
            combinationSum(candidates, target, actualNumber, i + 1, new ArrayList<>(option), options);

            var option2 = new ArrayList<>(option);
            option2.add(candidates[i+1]);
            if(!alreadyCheckedOptions.contains(option2)) {
                alreadyCheckedOptions.add(option2);
                combinationSum(candidates, target, actualNumber + candidates[i + 1], i + 1, new ArrayList<>(option2), options);
            }
        }
    }
}
