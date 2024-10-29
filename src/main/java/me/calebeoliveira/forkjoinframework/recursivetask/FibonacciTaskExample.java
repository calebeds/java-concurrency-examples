package me.calebeoliveira.forkjoinframework.recursivetask;

import java.util.concurrent.ForkJoinPool;

public class FibonacciTaskExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new FibonacciTask(25)));
    }
}
