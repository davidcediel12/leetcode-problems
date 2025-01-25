package com.example.demo.threesum;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<Integer> numbers = Arrays.stream(nums).boxed().toList();

        Set<List<Integer>> triplets = new HashSet<>();
        Set<List<Integer>> orderedTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int t1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int t2 = nums[j];
                int t3 = -t1 - t2;

                List<Integer> possibleTriplet = List.of(t1, t2, t3);
                List<Integer> orderedPossibleTriplet = possibleTriplet.stream().sorted().toList();

                boolean existsT3 = numbers.subList(j + 1, numbers.size()).contains(t3);
                boolean notRepeatedTriplet = !orderedTriplets.contains(orderedPossibleTriplet);

                if(j + 1 < nums.length && notRepeatedTriplet && existsT3){
                    triplets.add(possibleTriplet);
                    orderedTriplets.add(orderedPossibleTriplet);
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}
