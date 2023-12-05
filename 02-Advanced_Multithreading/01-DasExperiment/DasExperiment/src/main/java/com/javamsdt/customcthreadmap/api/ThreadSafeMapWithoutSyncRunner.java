package com.javamsdt.customcthreadmap.api;

import java.util.ConcurrentModificationException;

/**
 *
 */
public class ThreadSafeMapWithoutSyncRunner {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ThreadSafeMapWithoutSync<Integer, Integer> threadSafeMapWithoutSync = new ThreadSafeMapWithoutSync<>();

        Thread addThread = addHashMapIntegersThread(threadSafeMapWithoutSync);
        Thread sumThread = sumHashMapIntegersThread(threadSafeMapWithoutSync);

        addThread.start();

        Thread.sleep(1000);

        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addHashMapIntegersThread(ThreadSafeMapWithoutSync<Integer, Integer> threadSafeMapWithoutSync) {
        return new Thread(() -> {
            for (int i = 0; i < 50_000_000; i++) {
                threadSafeMapWithoutSync.put(i, i);
            }
        });
    }

    private static Thread sumHashMapIntegersThread(ThreadSafeMapWithoutSync<Integer, Integer> threadSafeMapWithoutSync) {

        return new Thread(() -> {
            long sum = 0;
            try {
//                for (Integer key : threadSafeMapWithoutSync.keySet()) {
//                    sum += threadSafeMapWithoutSync.get(key);
//                }

                for (Integer key : threadSafeMapWithoutSync.keySet()) {
                    sum += threadSafeMapWithoutSync.get(key);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Caught ConcurrentModificationException during the Sum operation");
            }

            System.out.println("The Sum of the HashMap values is:" + sum);
        });

    }

}
