package com.codecafe.concurrency.threadsignalling;

class Producer implements Runnable {

  MessageQueue queue;

  public Producer(MessageQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      String message = "message #" + i;
      try {
        queue.enqueue(message);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("sent - " + message);
    }
  }

}