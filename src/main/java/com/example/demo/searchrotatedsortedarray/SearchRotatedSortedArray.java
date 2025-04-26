package com.example.demo.searchrotatedsortedarray;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        int from = 0;
        int to = nums.length - 1;

        while (from < to - 1) {
            int pivot = (from + to) / 2;

            Integer pivotNumber = nums[pivot];
            if (pivotNumber == target) {
                return pivot;
            }
            if ((pivotNumber >= target && nums[from] <= target) ||
                    (nums[from] > pivotNumber  && (pivotNumber >= target || nums[to] < target))) {
                to = pivot;
            } else {
                from = pivot;
            }
        }
        if (nums[from] == target) {
            return from;
        }
        if (nums[to] == target) {
            return to;
        }
        return -1;
    }
}
