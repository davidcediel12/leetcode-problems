package com.example.demo.containerwithmostwater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int maxArea = 0;

        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){

                int maxHeight = Math.min(height[i], height[j]);

                int area = maxHeight * (j-i);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
