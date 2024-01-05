package com.example.javanewfeatures.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsync();
        supplierAsync();
        thenSupply();
    }

    private static void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> async = CompletableFuture.runAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println("runAsync Blocking 1");
        async.get();
        System.out.println("sunAsync Blokcing 2");
    }


    private static void supplierAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> async = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Eazy Byte";
        });

        System.out.println("supplying Async Blocking 1");
        String result=async.get();
        System.out.println(result);
        System.out.println("supplying Async Blokcing 2");
    }


    private static void thenSupply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Byte";
        });

        System.out.println("thenApply middle block");

        CompletableFuture<String> finalFuture = future.thenApply(name -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            return name + " Bytes";
        });

        System.out.println("thenApply before final block");
        System.out.println(finalFuture.get());
        System.out.println("thenApply Blocking");
    }


}
