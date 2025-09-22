package com.example.demo.jumpgametwo;

import java.util.HashMap;
import java.util.Map;

public class JumpGameTwo {

    int minJump = Integer.MAX_VALUE;

    Map<Integer, Integer> jumpsByPosition = new HashMap<>();

    public int jump(int[] nums) {
        return jump(nums, 0, 0);
    }


    private int jump(int[] nums, int actualIndex, int jumps) {

        if (jumpsByPosition.containsKey(actualIndex) && jumpsByPosition.get(actualIndex) <= jumps) {
            return jumpsByPosition.get(actualIndex);
        }

        if (jumps >= this.minJump) {
            jumpsByPosition.put(actualIndex, jumps);
            return jumps;
        }

        int maxForwardJump = nums[actualIndex];

        if (actualIndex == nums.length - 1) {
            jumpsByPosition.put(actualIndex, jumps);
            return jumps;
        }

        if (actualIndex + maxForwardJump >= nums.length - 1) {
            jumpsByPosition.put(actualIndex, jumps + 1);
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

        int requiredJumps = jump(nums, positionToJump, jumps + 1);

        if (requiredJumps < this.minJump) {
            this.minJump = requiredJumps;
        }

        jumpsByPosition.put(actualIndex, this.minJump);
        return this.minJump;
    }
}
