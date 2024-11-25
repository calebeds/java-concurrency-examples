package me.calebeoliveira.structuredtaskscope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencySuccess {
    public static void main(String[] args) throws InterruptedException {

        // we do not pool virtual threads: we create new ones for every task
        // and, we dispose them after they finished
        try(var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
            var process1 = new LongProcessFail(1, "result1", true);
            var process2 = new LongProcessFail(5, "result2", true);

            // we submit the tasks in parallel
            StructuredTaskScope.Subtask<String> res1 = scope.fork(process1);
            StructuredTaskScope.Subtask<String> res2 = scope.fork(process2);

            // because VIRTUAL THREADS
            scope.join();

            String result = null;
            try {
                result = scope.result();
                System.out.println(result);
            } catch (ExecutionException e) {
                System.out.println("There is no solution");
            }
        }
    }
}
