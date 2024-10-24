package me.calebeoliveira.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed {

    private final long duration;
    private final String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if(duration < ((DelayedWorker) other).getDuration()) {
            return -1;
        } else if(duration > ((DelayedWorker) other).getDuration()) {
            return +1;
        } else {
            return 0;
        }
    }



    public long getDuration() {
        return duration;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "message='" + message + '\'' +
                '}';
    }
}

public class DelayQueueExample {

    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();

        try {
            queue.put(new DelayedWorker(2000,"This is the first message..."));
            queue.put(new DelayedWorker(10000,"This is the second message..."));
            queue.put(new DelayedWorker(4500,"This is the third message..."));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
