package com.example.demo.mediantwosortedarrays;

public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int totalLength = nums1.length + nums2.length;
        boolean isLengthEven = totalLength % 2 == 0;

        int midPoint;
        int position = 0;

        if (isLengthEven) {
            midPoint = totalLength / 2 - 1;
        } else {
            midPoint = totalLength / 2;
        }

        int i = 0;
        int j = 0;
        int currentNumber;

        double counter = 0;
        boolean modifiedCounter = false;

        while (i < nums1.length || j < nums2.length) {

            if (j >= nums2.length) {
                currentNumber = nums1[i];
                i++;
            } else if (i >= nums1.length) {
                currentNumber = nums2[j];
                j++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    currentNumber = nums1[i];
                    i++;
                } else {
                    currentNumber = nums2[j];
                    j++;
                }
            }

            if (position >= midPoint) {
                if (isLengthEven) {
                    if (!modifiedCounter) {
                        counter += currentNumber;
                        modifiedCounter = true;
                    } else {
                        return (counter + currentNumber) / 2.0;
                    }
                } else {
                    return currentNumber;
                }
            }
            position++;
        }
        return 0;
    }
}
