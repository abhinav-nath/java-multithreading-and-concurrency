package com.codecafe.concurrency.thread.basics;

import java.io.IOException;

public class CopyTask implements Runnable {

  private final String sourceFile;
  private final String destFile;

  public CopyTask(String sourceFile, String destFile) {
    this.sourceFile = sourceFile;
    this.destFile = destFile;
  }

  @Override
  public void run() {
    try {
      IOUtils.copyFile(sourceFile, destFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}