package com.codecafe.concurrency.countdownlatch.timeout;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        // simulates a problem in execution
        if (true)
            throw new RuntimeException("Task failed to execute!");

        // this will never execute so the countDownLatch will wait indefinitely
        countDownLatch.countDown();
    }

}