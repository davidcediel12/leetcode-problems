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


    private void combinationSum(int[] candidates, int target, int actualNumber, int start,
                                List<Integer> option,
                                List<List<Integer>> options) {

        if (actualNumber > target) {
            return;
        }


        if (actualNumber == target) {
            options.add(new ArrayList<>(option));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            option.add(candidates[i]);
            combinationSum(candidates, target, actualNumber + candidates[i], i, option, options);
            option.removeLast();
        }
    }
}
