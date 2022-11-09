package com.codecafe.concurrency._synchronized._static;

class CountTask implements Runnable {
  public static final int PRINT_NUMBERS_UPTO = 10;
  static int number = 1;
  int remainder;
  static final Object lock = new Object();

  CountTask(int remainder) {
    this.remainder = remainder;
  }

  @Override
  public void run() {
    while (number < PRINT_NUMBERS_UPTO - 1) {
      synchronized (lock) {
        while (number % 3 != remainder) { // wait for numbers other than remainder
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() + " " + number);
        number++;
        lock.notifyAll();
      }
    }
  }
}

public class IncrementSequentiallyUsingMultipleThreads {

  public static void main(String[] args) {
    CountTask task1 = new CountTask(1);
    CountTask task2 = new CountTask(2);
    CountTask task3 = new CountTask(0);

    Thread t1 = new Thread(task1, "T1");
    Thread t2 = new Thread(task2, "T2");
    Thread t3 = new Thread(task3, "T3");

    t1.start();
    t2.start();
    t3.start();
  }

}