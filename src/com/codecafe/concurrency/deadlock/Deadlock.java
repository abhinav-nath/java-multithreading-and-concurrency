package com.codecafe.concurrency.deadlock;

class Writer1 extends Thread {

  final Object book;
  final Object pen;

  public Writer1(Object book, Object pen) {
    this.book = book;
    this.pen = pen;
  }

  @Override
  public void run() {
    synchronized (book) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (pen) {
        System.out.println("Writer1 writing");
      }
    }
  }

}

class Writer2 extends Thread {

  final Object book;
  final Object pen;

  public Writer2(Object book, Object pen) {
    this.book = book;
    this.pen = pen;
  }

  // lock sequence pen -> book will result in a deadlock
  // to solve this, change the lock sequence to book -> pen
  // thumb rule - lock sequence must always be same in all threads
  @Override
  public void run() {
    synchronized (pen) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (book) {
        System.out.println("Writer2 writing");
      }
    }
  }

}

public class Deadlock {

  public static void main(String[] args) {
    // dummy objects for book and pen
    Object book = new Object();
    Object pen = new Object();

    new Writer1(book, pen).start();
    new Writer2(book, pen).start();

    System.out.println("main is done");
  }

}