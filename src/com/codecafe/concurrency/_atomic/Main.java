package com.codecafe.concurrency._atomic;

class Task implements Runnable {

    private AtomicIntegerRoundRobin atomicIntegerRoundRobin;

    public Task(AtomicIntegerRoundRobin atomicIntegerRoundRobin) {
        this.atomicIntegerRoundRobin = atomicIntegerRoundRobin;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + atomicIntegerRoundRobin.index());
    }

}

public class Main {

    public static void main(String[] args) {

        AtomicIntegerRoundRobin atomicIntegerRoundRobin = new AtomicIntegerRoundRobin(3);

        new Thread(new Task(atomicIntegerRoundRobin), "T1").start();
        new Thread(new Task(atomicIntegerRoundRobin), "T2").start();
        new Thread(new Task(atomicIntegerRoundRobin), "T3").start();
        new Thread(new Task(atomicIntegerRoundRobin), "T4").start();
        new Thread(new Task(atomicIntegerRoundRobin), "T5").start();
        new Thread(new Task(atomicIntegerRoundRobin), "T6").start();

    }

}