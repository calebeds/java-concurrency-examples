package me.calebeoliveira.priority;

class Worker implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class PriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        System.out.println("This is in the main thread...");
    }
}
