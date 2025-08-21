package com.example.demo.combinationsumtwo;

import java.util.*;

public class CombinationSumTwo {

    Set<List<Integer>> analyzedOptions = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        Set<List<Integer>> options = new HashSet<>();

        combinationSum2(candidates, target, 0, new ArrayList<>(), options);
        return options.stream().toList();
    }

    private void combinationSum2(int[] candidates, int target, int start,
                                 List<Integer> currentOption, Set<List<Integer>> options) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            options.add(new ArrayList<>(currentOption));
        }

        for (int i = start; i < candidates.length; i++) {
            currentOption.add(candidates[i]);
            if(!analyzedOptions.contains(currentOption)) {
                analyzedOptions.add(new ArrayList<>(currentOption));
                combinationSum2(candidates, target - candidates[i], i + 1, currentOption, options);
            }
            currentOption.removeLast();
        }

    }
}
