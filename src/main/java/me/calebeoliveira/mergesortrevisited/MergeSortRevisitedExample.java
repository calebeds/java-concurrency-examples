package me.calebeoliveira.mergesortrevisited;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MergeSortRevisitedExample {
    public static void main(String[] args) {
        int[] nums = createNumbers(100_000_000);
        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        SequentialMergeSort sequentialMergeSort = new SequentialMergeSort(nums);

        System.out.println("Sequential Sort");
        long start = System.currentTimeMillis();
        sequentialMergeSort.sort();
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");


        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Parallel Sort");
        MergeSortTask parallel = new MergeSortTask(nums2);
        start = System.currentTimeMillis();
        pool.invoke(parallel);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int[] createNumbers(int n) {
        Random random = new Random();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }

        return nums;
    }

}
