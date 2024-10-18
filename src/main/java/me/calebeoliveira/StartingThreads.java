package me.calebeoliveira;

class Runnable1 implements Runnable {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }

    @Override
    public void run() {
        execute();
    }
}

class Runnable2 implements Runnable {
    public void execute() {
        for (int i = 0; i < 10; i++) {
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
        Thread t1 = new Thread(new Runnable1());
        Thread t2 = new Thread(new Runnable2());

        t1.start();
        t2.start();
    }
}