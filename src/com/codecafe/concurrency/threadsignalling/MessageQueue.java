package com.codecafe.concurrency.threadsignalling;

import java.util.ArrayList;
import java.util.List;

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