package me.calebeoliveira.volatileex;

class Worker implements Runnable {

    private volatile boolean isTerminated;

    @Override
    public void run() {
        while (!isTerminated()) {
            System.out.println("Worker class is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean isTerminated) {
        this.isTerminated = isTerminated;
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}
