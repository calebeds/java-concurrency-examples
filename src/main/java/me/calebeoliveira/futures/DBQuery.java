package me.calebeoliveira.futures;

public class DBQuery {
    public static String run() {
        System.out.println("DB operation started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DB operation finished...");
        return "Adam";
    }
}
