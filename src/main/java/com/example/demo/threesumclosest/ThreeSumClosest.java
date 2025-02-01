package com.example.demo.threesumclosest;

import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();

        int bestDifference = Integer.MAX_VALUE;
        int bestThreeSum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {

            int j = i + 1;
            int k = numbers.size() - 1;

            while (j < k) {
                int threeSum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                int actualDifference = Math.abs(target - threeSum);

                if (actualDifference == 0) {
                    return threeSum;
                }

                if (actualDifference < bestDifference) {
                    bestDifference = actualDifference;
                    bestThreeSum = threeSum;
                }

                if (threeSum > target) {
                    k--;
                } else {
                    j++;
                }
            }

            if (bestThreeSum > target) {
                return bestThreeSum;
            }
        }
        return bestThreeSum;
    }

}
