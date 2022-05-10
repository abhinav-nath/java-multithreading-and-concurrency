package com.codecafe.concurrency.thread.basics;

class MyThread1 extends Thread {
  public void run() {
    // Intentional infinite loop
    for (; ; ) {
      // Returns true if the thread is interrupted
      if (interrupted()) {
        // You are supposed to rollback or reverse the operation in progress and stop
        System.out.println("Thread is interrupted hence stopping...");
        // Terminates the loop
        break;
      }
      System.out.print("T");
    }
  }
}

public class StopAThreadInMiddle {

  public static void main(String[] args) {

    MyThread1 th = new MyThread1();
    th.start();

    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // th.stop();  never use this
    th.interrupt();
  }

}