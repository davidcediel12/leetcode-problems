package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        List<List<Integer>> numbersWithIndex = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numbersWithIndex.add(List.of(nums[i], i));
        }

        numbersWithIndex.sort(Comparator.comparingInt(num -> num.get(0)));


        for(int i = 0; i < numbersWithIndex.size(); i++){
            List<Integer> numWithIndex = numbersWithIndex.get(i);
            Integer n1 = numWithIndex.get(0);
            Integer missingNumber = target - n1;


            List<List<Integer>> toMakeBinarySearch = new ArrayList<>(numbersWithIndex);
            if(missingNumber >= n1) {
                int startingPoint = Math.min(numbersWithIndex.size() - 1, i + 1);
                toMakeBinarySearch = toMakeBinarySearch.subList(startingPoint, numbersWithIndex.size());
            } else {
                toMakeBinarySearch = toMakeBinarySearch.subList(0, i);
            }

            List<Integer> n2WithIndex = binarySearch(toMakeBinarySearch, missingNumber);

            if (n2WithIndex != null) {
                return new int[]{numWithIndex.get(1), n2WithIndex.get(1)};
            }

        }
        return new int[]{};

    }


    public List<Integer> binarySearch(List<List<Integer>> numbersWithIndex, Integer target) {


        while (numbersWithIndex.size() > 1) {
            Integer mean = numbersWithIndex.size() / 2;

            Integer pivot = numbersWithIndex.get(mean).get(0);
            if (pivot.equals(target)) {
                return numbersWithIndex.get(mean);
            }

            if (pivot < target) {
                numbersWithIndex = numbersWithIndex.subList(mean, numbersWithIndex.size());
            } else {
                numbersWithIndex = numbersWithIndex.subList(0, mean);
            }
        }

        if (numbersWithIndex.isEmpty() || !Objects.equals(numbersWithIndex.get(0).get(0), target)) {
            return null;
        }

        return numbersWithIndex.get(0);

    }
}