package com.codecafe.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

  private int delay;
  private CountDownLatch latch;

  public Task(int delay, CountDownLatch latch) {
    this.delay = delay;
    this.latch = latch;
  }

  @Override
  public void run() {

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    latch.countDown();

    System.out.println(Thread.currentThread().getName() + " finished");
  }

}