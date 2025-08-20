package com.example.demo.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> options = new ArrayList<>();

        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, new ArrayList<>(), options);
        return options;
    }


    private void combinationSum(int[] candidates, int target, int actualNumber, int i,
                                List<Integer> option,
                                List<List<Integer>> options) {

        if (i == candidates.length || actualNumber > target) {
            return;
        }


        if (actualNumber == target) {
            options.add(option);
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            var option1 = new ArrayList<>(option);
            option1.add(candidates[j]);
            combinationSum(candidates, target, actualNumber + candidates[j], j, option1, options);
        }
    }
}
