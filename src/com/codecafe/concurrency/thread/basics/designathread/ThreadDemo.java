package com.codecafe.concurrency.thread.basics.designathread;

class MyThread extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++)
      System.out.print("T");
  }
}

class MyTask implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++)
      System.out.print("-");
  }
}

public class ThreadDemo {

  public static void main(String[] args) {

    MyThread th1 = new MyThread();
    th1.start(); // submit the thread for execution

    // MyTask is runnable but it is not a thread
    MyTask task = new MyTask();
    // in order to run in inside a thread, we need to create a Thread object
    // and submit this task object for execution
    Thread th2 = new Thread(task);
    th2.start();

    for (int i = 0; i < 1000; i++)
      System.out.print("M");

  }
}