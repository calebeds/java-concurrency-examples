package me.calebeoliveira.virtualthread;

public class VirtualTaskWithoutRunnable {
    public static void run() {
        System.out.println("Started... " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished... " + Thread.currentThread().getName());
    }
}
