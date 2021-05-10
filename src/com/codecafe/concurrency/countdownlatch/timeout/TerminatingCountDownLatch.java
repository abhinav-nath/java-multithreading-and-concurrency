package com.codecafe.concurrency.countdownlatch.timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TerminatingCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread worker1 = new Thread(new Task(countDownLatch));
        Thread worker2 = new Thread(new Task(countDownLatch));
        Thread worker3 = new Thread(new Task(countDownLatch));

        worker1.start();
        worker2.start();
        worker3.start();

        // will wait forever
        // countDownLatch.await();

        boolean completed = countDownLatch.await(3, TimeUnit.SECONDS);

        System.out.println("countDownLatch completed = " + completed);
    }

}