package me.calebeoliveira.forkjoinframework.recursivetask;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Double> {
    private double num;

    public SimpleRecursiveTask(double num) {
        this.num = num;
    }

    @Override
    protected Double compute() {
        if(num > 100) {
            System.out.println("Parallel execution so split the task ... " + num);

            SimpleRecursiveTask task1 = new SimpleRecursiveTask(num / 2);
            SimpleRecursiveTask task2 = new SimpleRecursiveTask(num / 2);

            task1.fork();
            task2.fork();

            double subSolution = 0;

            subSolution += task1.join();
            subSolution += task2.join();

            return subSolution;
        } else {
            System.out.println("The task is small... we can execute it sequentially: " + num);
            return 2 * num;
        }
    }
}
