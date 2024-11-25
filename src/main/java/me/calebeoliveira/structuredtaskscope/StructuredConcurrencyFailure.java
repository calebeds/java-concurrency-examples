package me.calebeoliveira.structuredtaskscope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyFailure {
    public static void main(String[] args) throws InterruptedException {

        // we do not pool virtual threads: we create new ones for every task
        // and, we dispose them after they finished
        try(var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var process1 = new LongProcessFail(1, "result1", true);
            var process2 = new LongProcessFail(3, "result2", false);

            // we submit the tasks in parallel
            StructuredTaskScope.Subtask<String> res1 = scope.fork(process1);
            StructuredTaskScope.Subtask<String> res2 = scope.fork(process2);

            // because VIRTUAL THREADS
            scope.join();

            // if there is a failure in any of the child threads: other threads will be terminated
            try {
                scope.throwIfFailed();
            } catch (ExecutionException e) {
                System.out.println("Terminating all the threads");
            }

            // combine the results
            // get() will not block because the join() waits for the threads to finish


            System.out.println(res1.get() + " - " + res2.get());


            // it will shut down the scope after all child threads terminate
        }
    }
}
