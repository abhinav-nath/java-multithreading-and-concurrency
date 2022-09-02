package com.codecafe.concurrency.thread.joiningthreads;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    List<Long> numbers = List.of(5L, 5653L, 9090909L, 30467L, 27L, 2276L);

    List<FactorialTask> factorialTasks = new ArrayList<>();
    List<Thread> factorialThreads = new ArrayList<>();

    for (long number : numbers) {
      factorialTasks.add(new FactorialTask(number));
    }

    for (FactorialTask factorialTask : factorialTasks) {
      factorialThreads.add(new Thread(factorialTask));
    }

    for (Thread th : factorialThreads) {
      th.start();
    }

    for (Thread th : factorialThreads) {
      th.join(2000);
    }

    for (int i = 0; i < numbers.size(); i++) {
      FactorialTask factorialTask = factorialTasks.get(i);

      if (factorialTask.isFinished()) {
        System.out.println("Factorial of " + numbers.get(i) + " is " + factorialTask.getResult());
      } else {
        System.out.println("The calculation for " + numbers.get(i) + " is still in progress");
      }
    }
  }

}