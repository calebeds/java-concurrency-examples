package me.calebeoliveira.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AvoidingDeadlock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        AvoidingDeadlock deadlock = new AvoidingDeadlock();

        new Thread(deadlock::worker1, "worker1").start();
        new Thread(deadlock::worker2, "worker2").start();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("Worker1 acquire the lock2...");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock1.lock();
        System.out.println("Worker2 acquires the lock1...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("Worker2 acquire the lock2...");

        lock1.unlock();
        lock2.unlock();
    }
}
