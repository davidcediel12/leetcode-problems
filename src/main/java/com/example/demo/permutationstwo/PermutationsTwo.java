package com.example.demo.permutationstwo;

import java.util.*;

public class PermutationsTwo {

    Set<List<Integer>> results = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUnique(nums, 0, new LinkedHashMap<>());
        return results.stream().toList();
    }


    private void permuteUnique(int[] nums, int idx, Map<Integer, Integer> result) {

        if (result.size() >= nums.length) {
            results.add(result.values().stream().toList());
        }


        boolean traveledAllArray = false;
        int i = idx;

        while (!traveledAllArray) {


            if (!result.containsKey(i)) {

                result.put(i, nums[i]);
                permuteUnique(nums, i, result);
                result.remove(i);
            }


            i++;

            if(i >= nums.length){
                i = 0;
            }
            traveledAllArray = i == idx;
        }
    }
}
