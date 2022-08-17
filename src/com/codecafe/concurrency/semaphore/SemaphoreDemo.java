package com.codecafe.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemo {

  public static void main(String[] args) throws InterruptedException {
    // initialize the semaphore with number of permits
    Semaphore semaphore = new Semaphore(3);

    ExecutorService executor = Executors.newFixedThreadPool(50);

    IntStream.range(1, 1000).forEach(i -> executor.execute(new Task(semaphore)));

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);
  }

}