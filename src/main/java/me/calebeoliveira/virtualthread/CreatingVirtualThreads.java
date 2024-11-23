package me.calebeoliveira.virtualthread;

public class CreatingVirtualThreads {
    public static void main(String[] args) throws InterruptedException {

//        // approach #1
//        var builder = Thread.ofVirtual().name("virtual-", 0);
//
//        var t1 = builder.start(new VirtualTask());
//        var t2 = builder.start(new VirtualTask());
//
//        // all virtual threads are daemon threads!!!
//        t1.join();
//        t2.join();

        // approach #2
        var factory = Thread.ofVirtual().name("virtual-", 0).factory();

        var t1 = factory.newThread(new VirtualTask());
        var t2 = factory.newThread(new VirtualTask());

        t1.start();
        t2.start();

        // all virtual threads are daemon threads!!!
        t1.join();
        t2.join();


    }
}
