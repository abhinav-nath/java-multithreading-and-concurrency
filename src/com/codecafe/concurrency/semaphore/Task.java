package com.codecafe.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class Task implements Runnable {

    private Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // some processing

            semaphore.acquire();

            // critical section start
            Thread.sleep(1000);

            System.out.println(Thread.currentThread());
            // critical section end

            semaphore.release();

            // rest of processing

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}