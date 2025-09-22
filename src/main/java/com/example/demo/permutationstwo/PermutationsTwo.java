package com.example.demo.permutationstwo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationsTwo {

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

            if (result.add(nums[i])) {
                permute(nums, i, result);
                result.remove(nums[i]);
            }


            i++;

            if(i >= nums.length){
                i = 0;
            }
            traveledAllArray = i == idx;
        }
    }
}
