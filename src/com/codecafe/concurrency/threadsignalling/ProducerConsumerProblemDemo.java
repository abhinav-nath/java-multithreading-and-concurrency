package com.codecafe.concurrency.threadsignalling;

// Producer and Consumer problem
// producer produces messages at a faster rate than the consumer can consume

// MessageQueue acts as a buffer between the producer and consumer
//    producer --> messageQueue --> consumer

public class ProducerConsumerProblemDemo {

  public static void main(String[] args) {
    // buffer limit is set to 1
    MessageQueue queue = new MessageQueue(1);

    Thread producerThread = new Thread(new Producer(queue));
    Thread consumerThread = new Thread(new Consumer(queue));

    producerThread.start();
    consumerThread.start();
  }

}