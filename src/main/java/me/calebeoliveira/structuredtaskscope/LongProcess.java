package me.calebeoliveira.structuredtaskscope;

import java.time.Duration;
import java.util.concurrent.Callable;

public class LongProcess implements Callable<String> {

    private final String result;
    private final int timeToSleep;

    public LongProcess(int timeToSleep, String result) {
        this.timeToSleep = timeToSleep;
        this.result = result;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(Duration.ofSeconds(timeToSleep));
        return result;
    }
}
