package com.codecafe.concurrency.blockingqueue;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// both peek() and element() methods allow to get the
// first element of the queue without removing it

// the difference between peek() and element() is that
// if the queue is empty then peek() will return null
// but element() will throw a NoSuchElementException

public class PeekMethods {

  public static void main(String[] args) {

    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

    String element1 = blockingQueue.peek();

    try {
      String element2 = blockingQueue.element();
    } catch (NoSuchElementException e) {
      System.out.println("BlockingQueue is empty");
    }
  }

}