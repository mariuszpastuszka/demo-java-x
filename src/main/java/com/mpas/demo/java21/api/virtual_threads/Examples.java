package com.mpas.demo.java21.api.virtual_threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Examples {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test();
        test2();
        test3();
        test4();
    }

    private static void test() throws InterruptedException {
        Thread thread = Thread.ofVirtual().start(() -> System.out.println("Hello"));
        thread.join();
    }

    private static void test2() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("MyThread");
        Runnable task = () -> {
            System.out.println("Running thread");
        };
        Thread t = builder.start(task);
        System.out.println("Thread t name: " + t.getName());
        t.join();
    }

    private static void test3() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
        Runnable task = () -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        };

// name "worker-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

// name "worker-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");
    }

    private static void test4() throws ExecutionException, InterruptedException {
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
            future.get();
            System.out.println("Task completed");
            // ...
        }
    }
}
