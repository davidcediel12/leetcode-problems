package com.example.demo.permutations;

import java.util.*;

public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, new LinkedHashSet<>());
    }


    private List<List<Integer>> permute(int[] nums, int idx, Set<Integer> result) {

        if (result.size() >= nums.length) {
            return List.of(result.stream().toList());
        }


        boolean traveledAllArray = false;
        int i = idx;

        List<List<Integer>> results = new ArrayList<>();
        while (!traveledAllArray) {

            Set<Integer> newPermutation = new LinkedHashSet<>(result);

            if (newPermutation.add(nums[i])) {

                var permutations = permute(nums, i, newPermutation);

                permutations = permutations.stream().filter(p -> !p.isEmpty())
                        .toList();


                results.addAll(permutations);
            }

            i++;
            if(i >= nums.length){
                i = 0;
            }
            traveledAllArray = i == idx;
        }

        return results;
    }
}
