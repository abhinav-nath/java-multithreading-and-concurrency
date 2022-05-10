package com.codecafe.concurrency.thread.basics.designathread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyMath {
  public static int add(int a, int b) {
    return a + b;
  }
}

// Callable is useful where we want to return an object from the task
class MyAddTask implements Callable<Integer> {

  int x;
  int y;

  public MyAddTask(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Integer call() throws Exception {
    int result = x + y;
    return result;
  }
}

public class CallableDemo {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    int x = 10;
    int y = 20;

    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(new MyAddTask(x, y));

    while (!future.isDone()) ; // wait

    int z = future.get();

    executor.shutdown();

    System.out.println("Result is " + z);
  }

}