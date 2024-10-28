package me.calebeoliveira.mergesort;

import java.util.Random;

public class MergeSortExample {
    public static void main(String[] args) {
        final int numOfThreads = Runtime.getRuntime().availableProcessors();

        final int[] numbers1 = createArray(10);
        final int[] numbers2 = createArray(numbers1.length);

        for (int i = 0; i < numbers1.length; i++) {
            numbers2[i] = numbers1[i];
        }

        // Parallel merge sort
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(numbers1);
        long startTime1 = System.currentTimeMillis();
        parallelMergeSort.parallelMergeSort(0, numbers1.length - 1, numOfThreads);
        long endTime1 = System.currentTimeMillis();
        parallelMergeSort.showArray();

        System.out.printf("Time taken with parallel: %6d ms\n", endTime1 - startTime1);

        // Sequential merge sort
        long startTime2 = System.currentTimeMillis();
        MergeSort sequentialMergeSort = new MergeSort(numbers2);
        sequentialMergeSort.sort();
        long endTime2 = System.currentTimeMillis();
        System.out.printf("Time taken with sequential: %6d ms\n", endTime2 - startTime2);
        sequentialMergeSort.showArray();

    }

    private static int[] createArray(int n) {
        final Random random = new Random();
        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }

        return a;

    }
}
