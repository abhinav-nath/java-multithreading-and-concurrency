package com.codecafe.concurrency.thread.joiningthreads;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

  private final long number;
  private BigInteger result = BigInteger.ZERO;
  private boolean isFinished = false;

  public FactorialTask(long number) {
    this.number = number;
  }

  @Override
  public void run() {
    this.result = factorial(number);
    this.isFinished = true;
  }

  public BigInteger factorial(long n) {
    BigInteger tempResult = BigInteger.ONE;

    for (long i = n; i > 0; i--) {
      if (Thread.currentThread().isInterrupted()) {
        System.out.println(Thread.currentThread().getName() + " is interrupted hence stopping...");
        break;
      }
      tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
    }

    return tempResult;
  }

  public boolean isFinished() {
    return isFinished;
  }

  public BigInteger getResult() {
    return result;
  }

}
