package com.example.demo.jumpgametwo;

public class JumpGameTwo {

    int minJump = Integer.MAX_VALUE;


    public int jump(int[] nums) {
        return jump(nums, 0, 0);
    }


    private int jump(int[] nums, int actualIndex, int jumps) {

        if (jumps >= this.minJump) {
            return jumps;
        }

        int maxForwardJump = nums[actualIndex];

        if (actualIndex == nums.length - 1) {
            return jumps;
        }

        if (actualIndex + maxForwardJump >= nums.length) {
            return jumps + 1;
        }

        int i = 1;
        while (i <= maxForwardJump) {

            int requiredJumps = jump(nums, actualIndex + i, jumps + 1);

            if (requiredJumps < this.minJump) {
                this.minJump = requiredJumps;
            }
            i++;
        }
        return this.minJump;
    }
}
