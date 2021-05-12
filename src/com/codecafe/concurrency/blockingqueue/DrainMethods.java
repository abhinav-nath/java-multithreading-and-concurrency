package com.codecafe.concurrency.blockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// methods that drain a number of elements from the
// beginning of the queue into a target Collection

public class DrainMethods {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        Collection destination = new ArrayList();

        blockingQueue.drainTo(destination);

        blockingQueue.drainTo(destination, 5);

    }

}