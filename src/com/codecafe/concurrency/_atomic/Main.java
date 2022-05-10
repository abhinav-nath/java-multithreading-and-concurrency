package com.codecafe.concurrency._atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Task implements Runnable {

  private Semaphore semaphore;
  private AtomicIntegerRoundRobin atomicIntegerRoundRobin;

  public Task(Semaphore semaphore, AtomicIntegerRoundRobin atomicIntegerRoundRobin) {
    this.semaphore = semaphore;
    this.atomicIntegerRoundRobin = atomicIntegerRoundRobin;
  }

  @Override
  public void run() {
    try {
      semaphore.acquire();
      System.out.println(Thread.currentThread().getName() + " - " + atomicIntegerRoundRobin.index());
      Thread.sleep(1000);
      semaphore.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

public class Main {

  public static void main(String[] args) throws InterruptedException {

    AtomicIntegerRoundRobin atomicIntegerRoundRobin = new AtomicIntegerRoundRobin(5);

    // create a batch of 3 threads at a time
    Semaphore semaphore = new Semaphore(3);

    ExecutorService executor = Executors.newFixedThreadPool(50);

    IntStream.range(1, 50).forEach(i -> executor.execute(new Task(semaphore, atomicIntegerRoundRobin)));

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);

  }

}