package com.codecafe.concurrency.thread.basics;

import java.io.IOException;

public class BasicMultiThreading {

  public static void main(String[] args) throws IOException {

    String sourceFile1 = "a.txt";
    String destFile1 = "b.txt";

    String sourceFile2 = "c.txt";
    String destFile2 = "d.txt";

    // sequential
    // IOUtils.copyFile(sourceFile1, destFile1);
    // IOUtils.copyFile(sourceFile2, destFile2);

    // parallel
    Thread t1 = new Thread(new CopyTask(sourceFile1, destFile1));
    t1.start();

    Thread t2 = new Thread(new CopyTask(sourceFile2, destFile2));
    t2.start();

  }

}