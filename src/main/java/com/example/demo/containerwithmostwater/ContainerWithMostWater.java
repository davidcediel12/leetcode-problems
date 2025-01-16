package com.example.demo.containerwithmostwater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i != j) {

            int currentHeight = Math.min(height[i], height[j]);
            int area = currentHeight * (j - i);

            maxArea = Math.max(area, maxArea);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }

        }
        return maxArea;
    }
}
