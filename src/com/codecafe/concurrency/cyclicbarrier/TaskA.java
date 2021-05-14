package com.codecafe.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskA implements Runnable {

    private CyclicBarrier barrier;

    public TaskA(CyclicBarrier barrier) {
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
        System.out.println("TaskA started");
    }

}