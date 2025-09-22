package com.example.demo.jumpgametwo;

public class JumpGameTwo {

    public int jump(int[] nums) {
        return jump(nums, 0, 0);
    }


    private int jump(int[] nums, int actualIndex, int jumps) {

        int maxForwardJump = nums[actualIndex];

        if (actualIndex == nums.length - 1) {
            return jumps;
        }

        if (actualIndex + maxForwardJump >= nums.length) {
            return jumps + 1;
        }

        int i = 1;
        int minJumps = Integer.MAX_VALUE;
        while (i <= maxForwardJump) {

            int requiredJumps = jump(nums, actualIndex + i, jumps + 1);

            if (requiredJumps < minJumps) {
                minJumps = requiredJumps;
            }
            i++;
        }
        return minJumps;
    }
}
