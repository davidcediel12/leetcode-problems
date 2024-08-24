package com.example.demo;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numbers = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer missingNumber = target - nums[i];
            if(numbers.containsKey(missingNumber)) {
                Integer index = numbers.get(missingNumber);
                return new int[]{index, i};
            } else {
                numbers.put(nums[i], i);
            }
        }

        return new int[]{};
    }

}