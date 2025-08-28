package com.example.demo.trappingrainwater;

import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    public int trap(int[] height) {

//        return new TappingRainWaterTwoPointer().trap(height);
        int leftWallIndex = -1;
        int leftWallHeight = -1;

        int water = 0;

        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        List<Integer> leftHeights = Arrays.stream(height).boxed().toList().subList(0, maxHeightIndex + 1);

        for (int i = 0; i < leftHeights.size(); i++) {
            int actualHeight = leftHeights.get(i);

            if (actualHeight > leftWallHeight || actualHeight == maxHeight) {

                if (leftWallHeight > 0) {
                    water += calculateWater(leftHeights, i, leftWallIndex);
                }
                leftWallHeight = actualHeight;
                leftWallIndex = i;

            }
        }


        List<Integer> rightHeights = Arrays.stream(height).boxed().toList().subList(maxHeightIndex, height.length);

        int rightWallIndex = -1;
        int rightWallHeight = -1;

        for (int i = rightHeights.size() - 1; i >= 0; i--) {
            int actualHeight = rightHeights.get(i);

            if (actualHeight > rightWallHeight || actualHeight == maxHeight) {

                if (rightWallHeight > 0) {
                    water += calculateWaterReverseOrder(rightHeights, i, rightWallIndex);
                }
                rightWallHeight = actualHeight;
                rightWallIndex = i;

            }
        }


        return water;
    }

    private int calculateWater(List<Integer> heights, int actualIndex, int leftWallIndex) {


        Integer obstacles = heights.subList(leftWallIndex + 1, actualIndex).stream()
                .reduce(Integer::sum)
                .orElse(0);

        return heights.get(leftWallIndex) * (actualIndex - leftWallIndex - 1) - obstacles;
    }


    private int calculateWaterReverseOrder(List<Integer> heights, int actualIndex, int rightWallIndex) {


        Integer obstacles = heights.subList(actualIndex + 1, rightWallIndex).stream()
                .reduce(Integer::sum)
                .orElse(0);

        return heights.get(rightWallIndex) * (rightWallIndex - actualIndex - 1) - obstacles;
    }


    class TappingRainWaterTwoPointer {
        public int trap(int[] height) {
            int rightIndex = height.length - 1;
            int maxRight = height[rightIndex];

            int leftIndex = 0;
            int maxLeft = height[leftIndex];

            int water = 0;

            while(rightIndex > leftIndex){
                int actualHeight;
                int maxHeight;

                if(maxLeft <= maxRight){
                    leftIndex++;
                    actualHeight = height[leftIndex];
                    maxLeft = Math.max(maxLeft, actualHeight);
                    maxHeight = maxLeft;
                } else {
                    rightIndex--;
                    actualHeight = height[rightIndex];
                    maxRight = Math.max(maxRight, actualHeight);
                    maxHeight = maxRight;
                }

                water += (maxHeight - actualHeight);
            }

            return water;

        }
    }
}
