package me.calebeoliveira.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;

    private final Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            Thread.sleep(2000);
            System.out.println("Downloading data from the web...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(() -> {
                Downloader.INSTANCE.download();
            });
        }
        service.shutdown();
    }
}
