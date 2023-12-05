package com.javamsdt;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        BlockingObjectPool blockingObjectPool = new BlockingObjectPool(5);
        // Temporary holder for the objects returned from the pool
        Set<Object> objects = new HashSet<>();

        // Getting all the objects from the pool
        for (int i = 0; i < 5; i++) {
            Thread gettingThread = new Thread(() -> {
                Object object = blockingObjectPool.get();
                System.out.println("Getting Thread# " + Thread.currentThread().getId() + ", done reading object #" + object);
                objects.add(object);
            });
            gettingThread.start();
        }

        Thread.sleep(1000);

        // putting back objects to the pool from the temporary storage, to simulate finished work.
        for (int i = 0; i < objects.size() - 1; i++) {
            Object object = objects.toArray()[i];
            Thread returningThread = new Thread(() -> {
                blockingObjectPool.take(object);
                System.out.println("Returning Thread# " + Thread.currentThread().getId() + ", done returning object #" + object);
            });
            returningThread.start();
        }

        Thread.sleep(1000);

        // simulate returning to the pool objects more than the size of the pool
        for (int i = 0; i < objects.size(); i++) {
            Object obj = objects.toArray()[i];
            Thread producerThread = new Thread(() -> {
                blockingObjectPool.take(obj);
                System.out.println("Producer Thread# " + Thread.currentThread().getId() + ", done returning object #" + obj);
            });
            producerThread.start();
        }
    }
}
