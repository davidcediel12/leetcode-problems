package com.example.demo.permutations;

import java.util.*;

public class Permutations {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, new LinkedHashSet<>());
        return results;
    }


    private void permute(int[] nums, int idx, Set<Integer> result) {

        if (result.size() >= nums.length) {
            results.add(result.stream().toList());
        }


        boolean traveledAllArray = false;
        int i = idx;

        while (!traveledAllArray) {

            Set<Integer> newPermutation = new LinkedHashSet<>(result);

            if (newPermutation.add(nums[i])) {
                permute(nums, i, newPermutation);
            }

            i++;

            if(i >= nums.length){
                i = 0;
            }
            traveledAllArray = i == idx;
        }
    }
}
