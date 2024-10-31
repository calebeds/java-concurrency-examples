package me.calebeoliveira.forkjoinframework.maxfinding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MaximumFindingExample {
    public static void main(String[] args) {
        final long[] nums = createNumbers(500_000_000);

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        SequentialMaxFinding sequentialMaxFinding = new SequentialMaxFinding();

        long start = System.currentTimeMillis();
        System.out.println("Max: " + sequentialMaxFinding.max(nums));
        System.out.println("Time: " + (System.currentTimeMillis() - start));

        ParallelMaxTask parallelMaxTask = new ParallelMaxTask(nums, 0, nums.length);
        start = System.currentTimeMillis();
        System.out.println("Max: " + pool.invoke(parallelMaxTask));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    private static long[] createNumbers(int n) {
        Random random = new Random();

        final long[] nums = new long[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }

        return nums;
    }
}
