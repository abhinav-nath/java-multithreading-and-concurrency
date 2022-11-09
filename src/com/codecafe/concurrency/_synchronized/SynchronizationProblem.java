package com.codecafe.concurrency._synchronized;

class SharedResource {

  private int x;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  // run with and without synchronized to see the problem
  // 12 should be the correct output
  public synchronized void incr() {
    int y = getX();
    y++;

    try {
      Thread.sleep(1); // add delay for simulating some amount of processing
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    setX(y);
  }

}

class IncrementTask implements Runnable {

  private final SharedResource obj;

  public IncrementTask(SharedResource obj) {
    this.obj = obj;
  }

  @Override
  public void run() {
    obj.incr();
  }

}

public class SynchronizationProblem {

  public static void main(String[] args) {
    SharedResource obj = new SharedResource();
    obj.setX(10);

    Thread t1 = new Thread(new IncrementTask(obj));
    Thread t2 = new Thread(new IncrementTask(obj));

    long startTime = System.currentTimeMillis();
    t1.start();
    t2.start();

    try {
      t1.join(); // wait for thread to finish
      t2.join(); // wait for thread to finish
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }

    System.out.println("Total execution time : " + (System.currentTimeMillis() - startTime));
    System.out.println(obj.getX());
  }

}