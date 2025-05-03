package com.example.demo.firstlastpositionsortedarray;

import java.util.Arrays;
import java.util.List;

public class FirstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {

        List<Integer> result = searchNumbers(Arrays.stream(nums).boxed().toList(),
                target, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, nums.length - 1);
        return new int[]{
                result.getFirst() != Integer.MAX_VALUE ? result.getFirst() : -1,
                result.getLast() != Integer.MIN_VALUE ? result.getLast() : -1
        };
    }


    private List<Integer> searchNumbers(List<Integer> nums, int target, int minPosition, int maxPosition, int init, int end) {
        if(nums.isEmpty()){
            return List.of(minPosition, maxPosition);
        }
        if (init >= end - 1) {
            if (nums.get(init) == target) {
                minPosition = Math.min(minPosition, init);
                maxPosition = Math.max(maxPosition, init);
            }

            if (nums.get(end) == target) {
                minPosition = Math.min(minPosition, end);
                maxPosition = Math.max(maxPosition, end);
            }
            return List.of(minPosition, maxPosition);
        }
        int pivot = (init + end) / 2;
        System.out.println("Iteration");
        System.out.println("\t " + nums.subList(init, end + 1));
        System.out.println("\t pivot: " + pivot);
        System.out.println("\t number: " + nums.get(pivot));

        List<Integer> left = searchNumbers(nums, target, minPosition, maxPosition, init, pivot);
        List<Integer> right = searchNumbers(nums, target, minPosition, maxPosition, pivot + 1, end);

        System.out.println("\t Left: " + left);
        System.out.println("\t Right: " + right);
        return List.of(
                Math.min(left.getFirst(), right.getFirst()),
                Math.max(left.getLast(), right.getLast())
        );
    }

}
