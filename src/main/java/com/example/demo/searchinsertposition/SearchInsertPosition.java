package com.example.demo.searchinsertposition;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int init, int end) {

        if(init == end){
            if(nums[init] >= target){
                return init;
            }
            return init + 1;
        }

        if (init >= end-1) {
            if (nums[init] == target) {
                return init;
            }
            if(nums[end] == target){
                return end;
            }
            if (nums[init] > target) {
                return init;
            }
            if(nums[end] < target){
                return end + 1;
            }
            return end;


        }
        int pivot = (init + end) / 2;

        int pivotNumber = nums[pivot];

        if (pivotNumber == target) {
            return pivot;
        }

        if (target > pivotNumber) {
            return binarySearch(nums, target, pivot + 1, end);
        }

        return binarySearch(nums, target, init, pivot - 1);
    }
}
