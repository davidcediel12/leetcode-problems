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

        int i = 0, j = 0;
        double counter = 0;
        int currentNumber;
        boolean modifiedCounter = false;

        boolean movedI = true, movedJ = true;

        boolean finishedFirstArray = false, finishedSecondArray = false;

        while (i < nums1.length - 1 || j < nums1.length - 1) {

            if((nums1[i] <= nums2[j] && !finishedFirstArray) || finishedSecondArray){
                currentNumber = nums1[i];
                if (i + 1 == nums1.length) {
                    finishedFirstArray = true;
                }
            } else if ((nums2[j] <= nums1[i] && !finishedSecondArray) || finishedFirstArray){
                currentNumber = nums2[j];
                if (j + 1 == nums2.length) {
                    finishedSecondArray = true;
                }
            } else {
                return 0;
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
