package me.calebeoliveira.sequentialsum;

public class SequentialSum {
    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
