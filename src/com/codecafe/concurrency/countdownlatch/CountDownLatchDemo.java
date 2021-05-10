package com.codecafe.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Create 4 worker threads and start them
        Thread worker1 = new Thread(new Task(1000, latch), "WORKER-1");
        Thread worker2 = new Thread(new Task(2000, latch), "WORKER-2");
        Thread worker3 = new Thread(new Task(3000, latch), "WORKER-3");
        Thread worker4 = new Thread(new Task(4000, latch), "WORKER-4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

}