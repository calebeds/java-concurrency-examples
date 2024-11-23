package me.calebeoliveira.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatingVirtualThreadsWithExecutors {
    public static void main(String[] args) {
        // try with resource approach
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(VirtualTaskWithoutRunnable::run);
            executorService.submit(VirtualTaskWithoutRunnable::run);
            executorService.submit(VirtualTaskWithoutRunnable::run);
        }

    }
}
