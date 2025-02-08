package com.example.demo.foursum;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();

        Set<List<Integer>> quadruplets = new HashSet<>();

        for (int left = 0; left < numbers.size(); left++) {
            for (int left2 = left + 1; left2 < numbers.size() - 2; left2++) {

                int leftChild = left2 + 1;
                int rightChild = numbers.size() - 1;

                while (leftChild < rightChild) {

                    int sum = numbers.get(left) + numbers.get(left2) +
                            numbers.get(leftChild) + numbers.get(rightChild);

                    if (sum == target) {
                        quadruplets.add(List.of(numbers.get(left), numbers.get(left2),
                                numbers.get(leftChild), numbers.get(rightChild)));
                        leftChild++;
                        rightChild--;
                    } else if (sum > target) {
                        rightChild--;
                    } else {
                        leftChild++;
                    }
                }
            }
        }
        return new ArrayList<>(quadruplets);
    }


}
