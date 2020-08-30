package com.codecafe.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample {
    private int x;

    ReadWriteLock rw_lock = new ReentrantReadWriteLock();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incr() {

        Lock lock = rw_lock.writeLock();

        lock.lock(); // lock the object before proceeding with modification

        try {
            int y = getX();
            y++;

            try {
                Thread.sleep(1); // add delay to simulate some amount of processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setX(y);

        } finally {
            lock.unlock(); // unlock the object - good practice to do this inside finally block
        }
    }
}

class IncrementTask implements Runnable {

    private Sample obj;

    public IncrementTask(Sample obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.incr();
    }

}

public class RentrantLockDemo {

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
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total execution time : " + (System.currentTimeMillis() - startTime));
        System.out.println(obj.getX());
    }

}