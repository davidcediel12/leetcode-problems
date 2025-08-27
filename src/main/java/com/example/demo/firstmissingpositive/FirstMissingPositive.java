package com.example.demo.firstmissingpositive;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int absNum = Math.abs(nums[i]);
            if (absNum <= nums.length && nums[absNum - 1] > 0) {
                nums[absNum - 1] = -1 * nums[absNum - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
