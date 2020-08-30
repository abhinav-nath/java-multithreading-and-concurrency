package com.codecafe.concurrency.synchronize;

class Sample1 {

    static int a = 5; // static variables are NOT thread-safe
    int b = 10;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void increment() {

        synchronized(Sample1.class) {
            int c = a;
            c++;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = c;
        }

        synchronized(this) {
            b++;
        }
    }
}

class IncTask implements Runnable {
    Sample1 obj;

    public IncTask(Sample1 obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.increment();
    }

}

public class SynchronizationProblemWithStatic {

    public static void main(String[] args) {

        Sample1 obj1 = new Sample1();
        Sample1 obj2 = new Sample1();

        Thread t1 = new Thread(new IncTask(obj1));
        Thread t2 = new Thread(new IncTask(obj2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("a = %d\n", Sample1.a);
        System.out.printf("obj1 - b = %d\nobj2 - b = %d", obj1.getB(), obj2.getB());
    }

}