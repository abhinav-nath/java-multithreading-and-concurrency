package com.codecafe.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  private BlockingQueue<String> queue = null;

  public Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {

    try {
      queue.put("1");
      Thread.sleep(1000);

      queue.put("2");
      Thread.sleep(1000);

      queue.put("3");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}