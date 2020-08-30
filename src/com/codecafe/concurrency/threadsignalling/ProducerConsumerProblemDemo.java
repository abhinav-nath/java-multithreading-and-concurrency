package com.codecafe.concurrency.threadsignalling;

import java.util.ArrayList;
import java.util.List;

// Producer and Consumer problem
// producer produces messages at a faster rate than the consumer can consume

// MessageQueue acts as a buffer between the producer and consumer
//    producer --> messageQueue --> consumer

class MessageQueue {

    List<String> messages;
    int limit;

    // buffer is bounded
    public MessageQueue(int limit) {
        messages = new ArrayList<>();
        this.limit = limit;
    }

    public boolean isFull() {
        return messages.size() == limit;
    }

    public boolean isEmpty() {
        return messages.size() == 0;
    }

    public synchronized void enqueue(String message) throws InterruptedException {

        // releases the lock on the queue object and waits for the notification
        while (isFull()) {
            this.wait();
        }

        messages.add(message);

        // once producer sends the message, notify the consumer to consume the message
        this.notify();

        // and sleep
        Thread.sleep(100);
    }

    public synchronized String dequeue() throws InterruptedException {

        while (isEmpty()) {
            // wait till producer sends a message
            this.wait();
        }

        String message = messages.remove(0);

        // after consuming the message, signal the producer to send more messages
        this.notify();

        // and sleep
        Thread.sleep(1000);

        return message;
    }
}

class Producer implements Runnable {

    MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message = "message #" + i;
            try {
                queue.enqueue(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sent - " + message);
        }
    }

}

class Consumer implements Runnable {

    MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message;
            try {
                message = queue.dequeue();
                System.out.println("received - " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class ProducerConsumerProblemDemo {

    public static void main(String[] args) {

        MessageQueue queue = new MessageQueue(1); // buffer limit is set to 3

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

    }

}