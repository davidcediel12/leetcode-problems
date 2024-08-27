package com.example.demo.mediantwosortedarrays;

import java.util.HashSet;

public class MedianTwoSortedArrays {


    private boolean finishedFirstArray;
    private boolean finishedSecondArray;
    int currentNumber;
    int[] nums1;
    int[] nums2;
    int totalLength;
    boolean isLengthEven;

    int i;
    int j;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        this.nums1 = nums1;
        this.nums2 = nums2;

        totalLength = nums1.length + nums2.length;
        isLengthEven = totalLength % 2 == 0;

        int midPoint;
        int position = 0;

        if (isLengthEven) {
            midPoint = totalLength / 2 - 1;
        } else {
            midPoint = totalLength / 2;
        }

        i = 0;
        j = 0;

        double counter = 0;
        boolean modifiedCounter = false;

        boolean movedI = true, movedJ = true;

        finishedFirstArray = nums1.length == 0;
        finishedSecondArray = nums2.length == 0;

        HashSet<Integer> usedIndexesFirstArr = new HashSet<>();
        HashSet<Integer> usedIndexesSecondArr = new HashSet<>();


        while (!finishedFirstArray || !finishedSecondArray) {

            if (position >= midPoint) {
                findCurrentNumber(usedIndexesFirstArr, usedIndexesSecondArr);
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


            boolean moveOnFirstArray = finishedSecondArray ||
                    (!finishedFirstArray && nums1[i] <= nums2[j] && i + 1 < nums1.length);

            if (moveOnFirstArray) {
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


    private void findCurrentNumber(HashSet<Integer> usedIndexesFirstArr,
                                   HashSet<Integer> usedIndexesSecondArr) {

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
    }
}
