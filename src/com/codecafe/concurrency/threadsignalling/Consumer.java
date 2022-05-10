package com.codecafe.concurrency.threadsignalling;

class Consumer implements Runnable {

  MessageQueue queue;

  public Consumer(MessageQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      String message;
      try {
        message = queue.dequeue();
        System.out.println("received - " + message);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}