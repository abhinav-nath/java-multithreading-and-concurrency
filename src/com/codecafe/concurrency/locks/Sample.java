package com.codecafe.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample {

  private int x;

  ReadWriteLock rw_lock = new ReentrantReadWriteLock();

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void incr() {

    Lock lock = rw_lock.writeLock();

    lock.lock(); // lock the object before proceeding with modification

    try {
      int y = getX();
      y++;

      try {
        Thread.sleep(1); // add delay to simulate some amount of processing
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      setX(y);

    } finally {
      lock.unlock(); // unlock the object - good practice to do this inside finally block
    }
  }

}