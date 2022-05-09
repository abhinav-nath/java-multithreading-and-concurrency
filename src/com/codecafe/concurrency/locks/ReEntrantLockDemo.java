package com.codecafe.concurrency.locks;

public class ReEntrantLockDemo {

    public static void main(String[] args) {

        Sample obj = new Sample();
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