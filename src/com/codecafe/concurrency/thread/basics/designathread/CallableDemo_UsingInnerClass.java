package com.codecafe.concurrency.thread.basics.designathread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo_UsingInnerClass {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    int x = 10;
    int y = 20;

    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(new Callable<Integer>() {
      public Integer call() {
        return MyMath.add(x, y);
      }
    });

    while (!future.isDone()) ; // wait

    int z = future.get();

    executor.shutdown();

    System.out.println("Result is " + z);
  }

}