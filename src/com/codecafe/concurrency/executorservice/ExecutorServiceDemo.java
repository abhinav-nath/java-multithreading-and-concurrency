package com.codecafe.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.codecafe.concurrency.thread.basics.CopyTask;

public class ExecutorServiceDemo {

  public static void main(String[] args) {

    String sourceFile1 = "a.txt";
    String destFile1 = "b.txt";

    String sourceFile2 = "c.txt";
    String destFile2 = "d.txt";

    ExecutorService executor = Executors.newFixedThreadPool(5);

    executor.execute(new CopyTask(sourceFile1, destFile1));
    executor.execute(new CopyTask(sourceFile2, destFile2));

    executor.shutdown();
  }

}