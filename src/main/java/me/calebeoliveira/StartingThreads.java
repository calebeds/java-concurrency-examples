package me.calebeoliveira;

class Runnable1 extends Thread {
    public void execute() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("Runner1: " + i);
        }
    }

    @Override
    public void run() {
        try {
            execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Runnable2 extends Thread {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2: " + i);
        }
    }

    @Override
    public void run() {
        execute();
    }
}

public class StartingThreads {
    public static void main(String[] args) {
        Thread t1 = new Runnable1();
        Thread t2 = new Runnable2();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished with the Threads...");
    }
}