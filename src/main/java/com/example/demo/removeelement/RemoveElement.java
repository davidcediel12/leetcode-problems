package com.example.demo.removeelement;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {


        int actualIndex = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != val){
                k++;
                nums[actualIndex] = nums[i];
                actualIndex ++;
            }
        }
        return k;
    }
}
