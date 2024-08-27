package com.example.demo.mediantwosortedarrays;

import java.util.HashSet;

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

        int i = 0, j = 0;

        double counter = 0;
        boolean modifiedCounter = false;

        int currentNumber;

        boolean movedI = true, movedJ = true;

        boolean finishedFirstArray = nums1.length == 0;
        boolean finishedSecondArray = nums2.length == 0;

        HashSet<Integer> usedIndexesFirstArr = new HashSet<>();
        HashSet<Integer> usedIndexesSecondArr = new HashSet<>();


        while (!finishedFirstArray || !finishedSecondArray) {

            if (finishedSecondArray) {
                currentNumber = nums1[i];
                usedIndexesFirstArr.add(i);
                if (i + 1 == nums1.length) {
                    finishedFirstArray = true;
                }
            } else if (finishedFirstArray) {
                currentNumber = nums2[j];
                usedIndexesSecondArr.add(j);
                if (j + 1 == nums2.length) {
                    finishedSecondArray = true;
                }
            } else {
                if (usedIndexesSecondArr.contains(j) ||
                        (nums1[i] <= nums2[j] && !usedIndexesFirstArr.contains(i))) {

                    currentNumber = nums1[i];
                    usedIndexesFirstArr.add(i);
                    finishedFirstArray = i == nums1.length - 1;
                } else {
                    currentNumber = nums2[j];
                    usedIndexesSecondArr.add(j);
                    finishedSecondArray = j == nums2.length - 1;
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


            if (nums1[i] <= nums2[j] && i + 1 < nums1.length) {
                if (movedI) {
                    i++;
                    movedJ = false;
                } else {
                    movedI = true;
                    movedJ = false;
                }
            } else {
                if (movedJ) {
                    j++;
                    movedI = false;
                } else {
                    movedJ = true;
                    movedI = false;
                }
            }
            position++;
        }
        return 0;
    }
}
