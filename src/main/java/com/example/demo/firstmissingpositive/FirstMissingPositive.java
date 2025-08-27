package com.example.demo.firstmissingpositive;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int missingPositive = Integer.MAX_VALUE;
        boolean isOnePresent = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isOnePresent = true;
            } else if (nums[i] - 1 > 0 && nums[i] - 1 < missingPositive && (nums[i] - 1 != 1 || !isOnePresent)) {
                missingPositive = nums[i] - 1;
            } else if (nums[i] + 1 < missingPositive && nums[i] + 1 > 0 && (nums[i] + 1 != 1 || !isOnePresent)) {
                missingPositive = nums[i] + 1;
            }
        }

        return isOnePresent ?  missingPositive : 1;
    }
}
