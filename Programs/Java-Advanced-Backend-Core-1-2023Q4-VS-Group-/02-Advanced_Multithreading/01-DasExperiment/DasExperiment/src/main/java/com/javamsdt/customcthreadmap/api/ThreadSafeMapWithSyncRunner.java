package com.javamsdt.customcthreadmap.api;

import java.util.ConcurrentModificationException;

/**
 *
 */
public class ThreadSafeMapWithSyncRunner {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ThreadSafeMapWithSync<Integer, Integer> threadSafeMapWithSync = new ThreadSafeMapWithSync<>();

        Thread addThread = addHashMapIntegersThread(threadSafeMapWithSync);
        Thread sumThread = sumHashMapIntegersThread(threadSafeMapWithSync);

        addThread.start();

        Thread.sleep(1000);

        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addHashMapIntegersThread(ThreadSafeMapWithSync<Integer, Integer> threadSafeMapWithSync) {
        return new Thread(() -> {
            for (int i = 0; i < 50_000_000; i++) {
                threadSafeMapWithSync.add(i, i);
            }
        });
    }

    private static Thread sumHashMapIntegersThread(ThreadSafeMapWithSync<Integer, Integer> threadSafeMapWithSync) {

        return new Thread(() -> {
            long sum = 0;
            try {
//                for (Integer entry : threadSafeMapWithSync.values()) {
//                    sum += entry;
//                }


                for (Integer entry : threadSafeMapWithSync.getKeySet()) {
                    sum += threadSafeMapWithSync.get(entry);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Caught ConcurrentModificationException during the Sum operation");
            }

            System.out.println("The Sum of the HashMap values is:" + sum);
        });

    }

}
