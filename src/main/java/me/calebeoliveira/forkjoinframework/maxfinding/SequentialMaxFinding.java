package me.calebeoliveira.forkjoinframework.maxfinding;

public class SequentialMaxFinding {

    public long max(long[] nums) {
        long max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}
