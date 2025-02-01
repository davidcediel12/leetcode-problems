package com.example.demo.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();
        int left = 0;
        int right = numbers.size() - 1;

        List<List<Integer>> quadruplets = new ArrayList<>();

        while (left < right) {
            int leftChild = left + 1;
            int rightChild = right - 1;

            int sum = Integer.MAX_VALUE;
            while (leftChild < rightChild) {

                sum = numbers.get(left) + numbers.get(leftChild) + numbers.get(rightChild) + numbers.get(right);

                if (sum > target) {
                    rightChild--;
                } else if (sum < target) {
                    leftChild++;
                } else {
                    quadruplets.add(List.of(
                            numbers.get(left), numbers.get(leftChild), numbers.get(rightChild), numbers.get(right)));
                    leftChild++;
                    rightChild--;
                }
            }

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return quadruplets;

    }
}
