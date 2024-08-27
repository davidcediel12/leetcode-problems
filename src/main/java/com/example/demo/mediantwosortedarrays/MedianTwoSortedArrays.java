package com.example.demo.mediantwosortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> completeArray = new ArrayList<>(
                Arrays.stream(nums1).boxed().toList());

        completeArray.addAll(Arrays.stream(nums2).boxed().toList());
        completeArray.sort(Integer::compare);


        int midPoint = completeArray.size() / 2;
        if (completeArray.size() % 2 == 0) {
            return (completeArray.get(midPoint) + completeArray.get(midPoint - 1)) / 2.0;
        } else {
            return completeArray.get(midPoint);
        }
    }
}
