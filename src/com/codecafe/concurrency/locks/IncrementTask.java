package com.codecafe.concurrency.locks;

class IncrementTask implements Runnable {

  private Sample obj;

  public IncrementTask(Sample obj) {
    this.obj = obj;
  }

  @Override
  public void run() {
    obj.incr();
  }

}