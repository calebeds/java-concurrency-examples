package me.calebeoliveira.exchangerex;

import java.util.concurrent.Exchanger;

class FirstThread implements Runnable {

    private int counter;
    private final Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter++;
            System.out.println("FirstThread incremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println("FirstThread got the counter: " + counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class SecondThread implements Runnable {

    private int counter;
    private final Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter--;
            System.out.println("SecondThread decremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println("SecondThread got the counter: " + counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ExchangerExample {
    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();

        FirstThread firstThread = new FirstThread(exchanger);
        SecondThread secondThread = new SecondThread(exchanger);

        new Thread(firstThread).start();
        new Thread(secondThread).start();
    }
}
