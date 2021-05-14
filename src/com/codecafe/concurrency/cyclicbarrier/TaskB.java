package com.codecafe.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskB implements Runnable {

    private CyclicBarrier barrier;

    public TaskB(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Waits until all parties have invoked await on this barrier
            // call before starting any processing
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // some processing
        System.out.println("TaskB started");
    }

}