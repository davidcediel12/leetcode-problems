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

        if (actualIndex + maxForwardJump >= nums.length - 1) {

            return jumps + 1;
        }

        int i = 1;
        int maxPossibleJump = 0;
        int positionToJump = actualIndex;
        while (i <= maxForwardJump) {

            int nextJump = nums[actualIndex + i];

            if (i + nextJump > maxPossibleJump) {
                maxPossibleJump = i + nextJump;
                positionToJump = actualIndex + i;
            }
            i++;
        }

        return jump(nums, positionToJump, jumps + 1);
    }
}
