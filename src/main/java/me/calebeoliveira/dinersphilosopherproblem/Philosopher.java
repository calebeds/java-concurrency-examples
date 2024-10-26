package me.calebeoliveira.dinersphilosopherproblem;

import java.util.Random;

public class Philosopher implements Runnable {
    private final int id;
    private volatile boolean full;
    private final Chopstick leftChopStick;
    private final Chopstick rightChopStick;
    private final Random random;
    private int eatingCounter;

    public Philosopher(int id, Chopstick leftChopStick, Chopstick rightChopStick) {
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
    }

    @Override
    public void run() {
         try {
            while (!full) {
                think();
                if(leftChopStick.pickUp(this, State.LEFT)) {
                    if(rightChopStick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopStick.putDown(this, State.RIGHT);
                    }
                    leftChopStick.putDown(this, State.LEFT);
                }
            }
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }


    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
