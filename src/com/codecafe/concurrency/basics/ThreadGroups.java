package com.codecafe.concurrency.basics;

class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadGroups {

    public static void main(String[] args) {
        
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");
        myThreadGroup.setMaxPriority(7);

        Thread myThread = new Thread(myThreadGroup, new MyTask(), "DemoThread");
        myThread.start();

        System.out.println("System threads : ");

        Thread th = Thread.currentThread();
        ThreadGroup tg = th.getThreadGroup();

        while(tg.getParent() != null) {
            tg = tg.getParent();
        }
        tg.list();
    }

}
