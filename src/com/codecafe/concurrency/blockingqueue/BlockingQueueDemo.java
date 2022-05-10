package com.codecafe.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

  public static void main(String[] args) throws InterruptedException {

    BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    new Thread(producer).start();
    new Thread(consumer).start();

    Thread.sleep(4000);
  }

}