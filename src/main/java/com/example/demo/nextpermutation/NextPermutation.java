package com.example.demo.nextpermutation;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        nums = obtainNextPermutation(nums);
    }

    /**
     * This class is apart from the main one just to perform the tests
     *
     * @param nums actual permutation
     * @return next permutation
     */
    public int[] obtainNextPermutation(int[] nums) {

        int indexToStartSort = 0;
        boolean foundSwap = false;

        int i = nums.length - 2;

        while (i >= 0 && !foundSwap) {
            int j = nums.length - 1;
            while (j > i && !foundSwap) {
                if (nums[j] > nums[i]) {

                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;

                    indexToStartSort = i + 1;

                    foundSwap = true;
                }
                j--;
            }
            i--;
        }

        int l = nums.length - 1;
        // reverse
        while (indexToStartSort < l) {
            int temp = nums[indexToStartSort];
            nums[indexToStartSort] = nums[l];
            nums[l] = temp;
            indexToStartSort++;
            l--;
        }
        return nums;
    }
}
