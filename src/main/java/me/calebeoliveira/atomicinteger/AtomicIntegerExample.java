package me.calebeoliveira.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(AtomicIntegerExample::increment);

        Thread thread2 = new Thread(AtomicIntegerExample::increment);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter: " + counter);
    }

    public static void increment() {
        for (int i = 0; i < 10000; i++) {
            counter.getAndIncrement();
        }
    }
}
