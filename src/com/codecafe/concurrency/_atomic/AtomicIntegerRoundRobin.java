package com.codecafe.concurrency._atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerRoundRobin {

  private final int totalIndexes;
  private final AtomicInteger atomicInteger = new AtomicInteger(0);

  public AtomicIntegerRoundRobin(int totalIndexes) {
    this.totalIndexes = totalIndexes;
  }

  public synchronized int index() {
    atomicInteger.compareAndSet(totalIndexes + 1, 0);

    int index = atomicInteger.get();

    atomicInteger.getAndIncrement();

    return index;
  }

}