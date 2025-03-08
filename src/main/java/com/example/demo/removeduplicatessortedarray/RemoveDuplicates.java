package com.example.demo.removeduplicatessortedarray;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        Set<Integer> existing = new HashSet<>();
        int toSwap;
        int virtualEnd = nums.length;

        for(int i = 0; i < virtualEnd; i++){

            if(existing.contains(nums[i])){
                toSwap = nums[i];

                int j = i + 1;
                while (j < virtualEnd && nums[j] == toSwap){
                    j++;
                }

                boolean noDifferentNumbers = j == virtualEnd;

                if(noDifferentNumbers){
                    return nums[i];
                }

                existing.add(nums[j]);
                int positionsToSwap = j - i;

                while (j < virtualEnd){
                    nums[j-positionsToSwap] = nums[j];
                    j++;
                }

                virtualEnd = virtualEnd - positionsToSwap;

            } else {
                existing.add(nums[i]);
            }
        }
        return existing.size();
    }
}
