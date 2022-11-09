package com.codecafe.concurrency._volatile;

class Task implements Runnable {

  private volatile boolean isRunning = true;

  @Override
  public void run() {
    while (isRunning) {
      System.out.println(Thread.currentThread().getName() + " running");
    }
  }

  public void shutdown() {
    isRunning = false;
    System.out.println("terminated by : " + Thread.currentThread().getName());
  }

}

public class VolatileDemo {

  public static void main(String[] args) throws InterruptedException {
    Task task = new Task();

    new Thread(task, "T1").start();
    new Thread(task, "T2").start();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    task.shutdown();
  }

}