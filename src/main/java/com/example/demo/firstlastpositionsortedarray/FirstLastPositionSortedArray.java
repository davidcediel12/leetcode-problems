package com.example.demo.firstlastpositionsortedarray;

public class FirstLastPositionSortedArray {

    int maxPosition = Integer.MIN_VALUE;
    int minPosition = Integer.MAX_VALUE;

    public int[] searchRange(int[] nums, int target) {

        searchNumbers(nums, target, 0, nums.length - 1);

        return new int[]{
                minPosition != Integer.MAX_VALUE ? minPosition : -1,
                maxPosition != Integer.MIN_VALUE ? maxPosition : -1
        };
    }


    private void searchNumbers(int[] nums, int target, int init, int end) {
        if (nums.length == 0) {
            return;
        }

        if (nums[end] < target || nums[init] > target) {
            return;
        }
        if (init >= end - 1) {
            if (nums[init] == target) {
                minPosition = Math.min(minPosition, init);
                maxPosition = Math.max(maxPosition, init);
            }

            if (nums[end] == target) {
                minPosition = Math.min(minPosition, end);
                maxPosition = Math.max(maxPosition, end);
            }
            return;
        }
        int pivot = (init + end) / 2;

        searchNumbers(nums, target, init, pivot);
        searchNumbers(nums, target, pivot + 1, end);
    }

}
