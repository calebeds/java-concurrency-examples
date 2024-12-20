package me.calebeoliveira.livelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExampleSolved {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);


    public static void main(String[] args) {
        LivelockExampleSolved livelockExample = new LivelockExampleSolved();

        new Thread(livelockExample::worker1, "worker1").start();
        new Thread(livelockExample::worker2, "worker2").start();
    }

    private void worker1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker1 acquires the lock1");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker1 tries to get lock2...");

            if(lock2.tryLock()) {
                System.out.println("Worker1 acquires the lock2...");
                lock2.unlock();
            } else {
                System.out.println("Worker1 can not acquire lock2...");
                continue;
            }

            break;
        }
        lock1.unlock();
    }

    private void worker2() {
        while (true) {
            try {
                lock1.tryLock(10, TimeUnit.MILLISECONDS);
                System.out.println("Worker2 acquires the lock1");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker2 tries to get lock2...");

            if(lock2.tryLock()) {
                System.out.println("Worker2 acquires the lock2...");
                lock2.unlock();
            } else {
                System.out.println("Worker2 can not acquire lock2...");
                continue;
            }

            break;
        }
        lock1.unlock();
    }
}
