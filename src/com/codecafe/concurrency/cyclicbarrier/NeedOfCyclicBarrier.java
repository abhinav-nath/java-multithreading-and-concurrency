package com.codecafe.concurrency.cyclicbarrier;

public class NeedOfCyclicBarrier {

  public static void main(String[] args) {
    // We want TaskA to be started along with TaskB
    // but it will not happen here
    // TaskA will start and then main processing will happen
    // and after 5 seconds, TaskB will start
    Thread t1 = new Thread(() -> System.out.println("TaskA started"));

    t1.start();

    // simulate some processing in main thread
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // start a new thread to run TaskB
    new Thread(() -> System.out.println("TaskB started")).start();
  }

}