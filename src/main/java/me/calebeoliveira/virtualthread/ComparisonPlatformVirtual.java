package me.calebeoliveira.virtualthread;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComparisonPlatformVirtual {
    public static void main(String[] args) {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 10_000_000; i++) {
            service.submit(() -> {
                System.out.println("Thread " + Thread.currentThread());
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
