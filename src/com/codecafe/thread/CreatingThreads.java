package com.codecafe.thread;

class MyThread extends Thread {

    @Override
    public void run() {
        for(int i=0; i < 1000; i++)
            System.out.print("T");
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for(int i=0; i < 1000; i++)
            System.out.print("-");
    }
}

public class CreatingThreads {

    public static void main(String[] args) {
        
        MyThread th1 = new MyThread();
        th1.start();   // submit the thread for execution
        
        MyTask task = new MyTask();
        Thread th2 = new Thread(task);
        th2.start();

        for(int i=0; i < 1000; i++)
            System.out.print("M");

    }
}