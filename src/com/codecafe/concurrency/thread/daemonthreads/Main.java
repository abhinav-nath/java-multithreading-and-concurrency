package com.codecafe.concurrency.thread.daemonthreads;

public class Main {

  public static void main(String[] args) {
    // Daemon thread
    Thread th = new Thread(() -> {
      for (int i = 1; i <= 10000; i++)
        System.out.print(" D-" + i);
    });

    th.setDaemon(true);
    th.start();

    // User thread or Main thread
    for (int i = 1; i <= 200; i++) {
      System.out.print(" U-" + i);
    }
  }

}