package com.example.demo.trappingrainwater;

import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    public int trap(int[] height) {

        int leftWallIndex = -1;
        int leftWallHeight = -1;

        int water = 0;
        List<Integer> heights = Arrays.stream(height).boxed().toList();

        for (int i = 0; i < height.length; i++) {
            int actualHeight = height[i];

            if (actualHeight > leftWallHeight) {

                if (leftWallHeight > 0) {
                    water += calculateWater(heights, i, leftWallIndex);
                }
                leftWallHeight = actualHeight;
                leftWallIndex = i;

            }
        }

        int rightWallIndex = -1;
        int rightWallHeight = -1;

        for (int i = height.length - 1; i >= 0; i--) {
            int actualHeight = height[i];

            if (actualHeight > rightWallHeight) {

                if (rightWallHeight > 0) {
                    water += calculateWaterReverseOrder(heights, i, rightWallIndex);
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
}
