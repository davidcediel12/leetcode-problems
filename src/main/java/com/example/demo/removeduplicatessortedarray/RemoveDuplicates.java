package com.example.demo.removeduplicatessortedarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {



    public int removeDuplicates(int[] nums) {

        int actualNumber = -101;
        int actualIndex = 0;
        int different = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] != actualNumber){
                actualNumber = nums[i];

                nums[actualIndex] = nums[i];

                actualIndex++;
                different++;
            }
        }

        return different;
    }

    @Deprecated(since = "Runtime 6ms")
    public int removeDuplicates2(int[] nums) {

        Set<Integer> existing = new HashSet<>();
        int toSwap;
        int virtualEnd = nums.length;

        for (int i = 0; i < virtualEnd; i++) {

            if (existing.contains(nums[i])) {
                toSwap = nums[i];

                int j = i + 1;
                while (j < virtualEnd && nums[j] == toSwap) {
                    j++;
                }

                boolean noDifferentNumbers = j == virtualEnd;

                if (noDifferentNumbers) {
                    return existing.size();
                }

                existing.add(nums[j]);
                int positionsToSwap = j - i;

                while (j < virtualEnd) {
                    nums[j - positionsToSwap] = nums[j];
                    j++;
                }

                virtualEnd = virtualEnd - positionsToSwap;

            } else {
                existing.add(nums[i]);
            }
        }
        return existing.size();
    }

    @Deprecated(since = "Runtime 8ms")
    public int removeDuplicates3(int[] nums) {


        List<Integer> distinctNumbers = Arrays.stream(nums)
                .boxed()
                .distinct().toList();


        for (int i = 0; i < distinctNumbers.size(); i++) {
            nums[i] = distinctNumbers.get(i);
        }

        return distinctNumbers.size();
    }






}
