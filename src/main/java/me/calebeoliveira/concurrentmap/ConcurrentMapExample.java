package me.calebeoliveira.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable {

    private final ConcurrentMap<String, Integer> map;

    public MapFirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            this.map.put("B", 12);
            Thread.sleep(1000);
            this.map.put("Z", 5);
            this.map.put("A", 25);
            Thread.sleep(2000);
            this.map.put("B", 19);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MapSecondWorker implements Runnable {

    private final ConcurrentMap<String, Integer> map;

    public MapSecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(this.map.get("A"));
            Thread.sleep(2000);
            System.out.println(this.map.get("Z"));
            System.out.println(this.map.get("B"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ConcurrentMapExample {



    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        MapFirstWorker firstWorker = new MapFirstWorker(map);
        MapSecondWorker secondWorker = new MapSecondWorker(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }

}
