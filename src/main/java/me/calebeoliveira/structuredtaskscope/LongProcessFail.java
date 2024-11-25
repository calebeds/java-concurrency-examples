package me.calebeoliveira.structuredtaskscope;

import java.time.Duration;
import java.util.concurrent.Callable;

public class LongProcessFail implements Callable<String> {

    private final String result;
    private final int timeToSleep;
    private final boolean fail;

    public LongProcessFail(int timeToSleep, String result, boolean fail) {
        this.timeToSleep = timeToSleep;
        this.result = result;
        this.fail = fail;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Starting thread " + result);
        Thread.sleep(Duration.ofSeconds(timeToSleep));
        if(fail) {
            System.out.println("Failure in child thread: " + result);
            throw new RuntimeException("Error");
        }

        System.out.println("Finishing thread: " + result);

        return result;
    }
}
