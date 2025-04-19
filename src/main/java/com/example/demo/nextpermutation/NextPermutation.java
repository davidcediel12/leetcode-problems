package com.example.demo.nextpermutation;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        nums = obtainNextPermutation(nums);
    }

    public int[] obtainNextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {

                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    return nums;
                }
            }
        }
        return new int[0];
    }
}
