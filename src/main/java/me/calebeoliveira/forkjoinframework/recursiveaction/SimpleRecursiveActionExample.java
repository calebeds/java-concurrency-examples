package me.calebeoliveira.forkjoinframework.recursiveaction;

import java.util.concurrent.ForkJoinPool;

public class SimpleRecursiveActionExample {
    public static void main(String[] args) {
        SimpleRecursiveAction action = new SimpleRecursiveAction(800);
        action.invoke();
    }
}
