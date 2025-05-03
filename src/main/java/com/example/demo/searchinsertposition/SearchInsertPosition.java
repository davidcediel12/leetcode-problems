package com.example.demo.searchinsertposition;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int init, int end) {

        System.out.println("Iteration");
        System.out.println("\tinit: " + init + " end: " + end);
        if (init == end) {
            if (nums[init] == target) {
                return init;
            }
            if (nums[init] > target) {
                return Math.max(0, init - 1);
            }

            return init + 1;
        }
        int pivot = (init + end) / 2;

        int pivotNumber = nums[pivot];

        System.out.println("\tpivot: " + pivot + " pivotNumber: " + pivotNumber);
        if (pivotNumber == target) {
            return pivot;
        }

        if (target > pivotNumber) {
            return binarySearch(nums, target, pivot + 1, end);
        }

        return binarySearch(nums, target, init, pivot - 1);
    }
}
