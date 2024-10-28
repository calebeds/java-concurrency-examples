package me.calebeoliveira.sequentialsum;

import java.util.Random;

public class SumExample {
    public static void main(String[] args) {
        final Random random = new Random();


        final int[] nums = new int[10_000_000];

        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = random.nextInt(100);
        }

        final int numberOfThreads = Runtime.getRuntime().availableProcessors();

        // sequential sum algorithm
        SequentialSum sequentialSum = new SequentialSum();
        long start = System.currentTimeMillis();
        System.out.println("Sum is equal to " + sequentialSum.sum(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - start));

        //parallel algorithm
        ParallelSum parallelSum = new ParallelSum(numberOfThreads);
        start = System.currentTimeMillis();
        System.out.println("Parallel sum: " + parallelSum.sum(nums));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - start));
    }
}
