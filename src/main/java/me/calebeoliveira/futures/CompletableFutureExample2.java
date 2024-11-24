package me.calebeoliveira.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletableFutureExample2 {
    public static void main(String[] args) {

        try(var service = Executors.newVirtualThreadPerTaskExecutor()) {
            String result = CompletableFuture.supplyAsync(DBQuery::run, service)
                    .thenCombine(CompletableFuture.supplyAsync(RESTQuery::run, service), (res1, res2) -> res1 + res2)
                    .join();

            System.out.println(result);
        }
//        CompletableFuture.supplyAsync(() -> "Hello ")
//                .thenCombine(CompletableFuture.supplyAsync(() -> "World!"), (s1, s2) -> s1 + s2)
//                .thenApply(s -> s.toUpperCase())
//                .thenAccept(System.out::println);
    }
}
