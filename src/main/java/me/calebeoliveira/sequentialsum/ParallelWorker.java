package me.calebeoliveira.sequentialsum;

public class ParallelWorker extends Thread {
    private final int[] nums;
    private final int low;
    private final int high;
    private int partialSum;

    public ParallelWorker(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = Math.min(nums.length, high);
    }


    @Override
    public void run() {
        for (int i = low; i < high; i++) {
            partialSum += nums[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
