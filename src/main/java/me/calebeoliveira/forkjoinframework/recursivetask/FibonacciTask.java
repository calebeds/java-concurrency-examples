package me.calebeoliveira.forkjoinframework.recursivetask;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private int n;

    public FibonacciTask(int n) {
        this.n = n;
    }


    @Override
    protected Integer compute() {
        if(n <= 1) {
            return n;
        }

        FibonacciTask fib1 = new FibonacciTask(n - 1);
        FibonacciTask fib2 = new FibonacciTask(n - 2);

        fib1.fork();
        fib2.fork();

        return fib1.join() + fib2.join();
    }
}
