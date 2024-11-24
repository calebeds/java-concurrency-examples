package me.calebeoliveira.futures;

public class RESTQuery {
    public static String run() {
        System.out.println("REST operation started...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("REST operation finished...");
        return " 23";
    }
}
