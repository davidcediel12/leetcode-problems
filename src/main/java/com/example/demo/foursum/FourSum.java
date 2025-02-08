package com.example.demo.foursum;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();

        Set<List<Integer>> quadruplets = new HashSet<>();

        for (int left = 0; left < numbers.size(); left++) {

            if (left > 0 && numbers.get(left).equals(numbers.get(left - 1))) {
                continue;
            }
            for (int left2 = left + 1; left2 < numbers.size() - 2; left2++) {

                if (left2 > left + 1 && numbers.get(left2).equals(numbers.get(left2 - 1))) {
                    continue;
                }

                int leftChild = left2 + 1;
                int rightChild = numbers.size() - 1;

                while (leftChild < rightChild) {

                    long sum = (long) numbers.get(left) + numbers.get(left2) +
                            numbers.get(leftChild) + numbers.get(rightChild);

                    if (sum == target) {
                        quadruplets.add(List.of(numbers.get(left), numbers.get(left2),
                                numbers.get(leftChild), numbers.get(rightChild)));
                        leftChild++;
                        rightChild--;
                    } else if (sum > target) {
                        do {
                            rightChild--;
                        } while (rightChild > leftChild && numbers.get(rightChild).equals(numbers.get(rightChild + 1)));
                    } else {
                        do {
                            leftChild++;
                        } while (leftChild < rightChild && numbers.get(left).equals(numbers.get(leftChild - 1)));
                    }
                }
            }
        }
        return new ArrayList<>(quadruplets);
    }


}
