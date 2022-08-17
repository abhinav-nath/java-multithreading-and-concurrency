package com.codecafe.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  public static void main(String[] args) {
    // create a CycliBarrier with 2 participating threads
    // CyclicBarrier will trip only when both 2 threads
    // invoke the await() method
    CyclicBarrier barrier = new CyclicBarrier(2);

    // now TaskA will start only when TaskB joins
    new Thread(new TaskA(barrier)).start();

    // simulate some processing in main thread
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // start a new thread to run TaskB
    new Thread(new TaskB(barrier)).start();
  }

}