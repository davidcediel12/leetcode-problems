package com.example.demo.threesum;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();
        Set<List<Integer>> orderedTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int t1 = nums[i];
                    int t2 = nums[j];
                    int t3 = nums[k];

                    List<Integer> possibleTriplet = List.of(t1, t2, t3);
                    List<Integer> orderedPossibleTriplet = possibleTriplet.stream().sorted().toList();

                    if (t1 + t2 + t3 == 0 && !orderedTriplets.contains(orderedPossibleTriplet)) {
                        triplets.add(possibleTriplet);
                        orderedTriplets.add(orderedPossibleTriplet);
                    }
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}
