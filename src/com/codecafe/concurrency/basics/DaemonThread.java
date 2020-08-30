package com.codecafe.concurrency.basics;

public class DaemonThread {

    public static void main(String[] args) {

        Thread th = new Thread(() -> {
            for ( ; ; )
                System.out.print("T");
        });

        th.setDaemon(true);
        th.start();

        for (int i = 0; i < 200; i++) {
            System.out.print(" M ");
        }
    }
}