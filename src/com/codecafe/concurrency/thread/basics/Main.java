package com.codecafe.concurrency.thread.basics;

class LongComputationTask implements Runnable {

  @Override
  public void run() {
    // Intentional infinite loop to simulate a long computation task
    for (; ; ) {
      // Returns true if the thread is interrupted
      if (Thread.currentThread().isInterrupted()) {
        // You are supposed to roll back or reverse the operation in progress and stop
        System.out.println("\nThread is interrupted hence stopping...");
        // Terminates the loop
        break;
      }
      System.out.print("T");
    }
  }

}

public class Main {

  public static void main(String[] args) {
    Thread th = new Thread(new LongComputationTask());
    th.start();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // th.stop();  never use this
    th.interrupt();
  }

}