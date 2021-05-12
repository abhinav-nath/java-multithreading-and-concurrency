package com.codecafe.concurrency.threadsignalling;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer and Consumer problem
// producer produces messages at a faster rate than the consumer can consume

// Revision of the original solution - use BlockingQueue instead of using our own MessageQueue

class _Producer implements Runnable {

    BlockingQueue<String> queue;

    public _Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message = "message #" + i;
            try {
                // Inserts the specified element into this queue, waiting if necessary for space to become available
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sent - " + message);
        }
    }

}


class _Consumer implements Runnable {

    BlockingQueue<String> queue;

    public _Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message;
            try {
                // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available
                message = queue.take();
                System.out.println("received - " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


public class ProducerConsumerProblemBlockingQueueDemo {

    public static void main(String[] args) {

        // buffer limit is set to 3
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

        Thread producerThread = new Thread(new _Producer(queue));
        Thread consumerThread = new Thread(new _Consumer(queue));

        producerThread.start();
        consumerThread.start();

    }

}