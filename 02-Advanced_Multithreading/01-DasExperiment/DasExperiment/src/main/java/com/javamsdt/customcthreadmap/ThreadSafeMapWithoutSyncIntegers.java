package com.javamsdt.customcthreadmap;

import java.util.ConcurrentModificationException;
import java.util.HashMap;

import com.javamsdt.customcthreadmap.api.ThreadSafeMapWithoutSync;

/**
 *
 */
public class ThreadSafeMapWithoutSyncIntegers {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ThreadSafeMapWithoutSync<Integer, Integer> threadSafeMap = new ThreadSafeMapWithoutSync<>();
        int[] values = { 10, 15, 40, 30, 5 };
        Thread addThread = addHashMapIntegersThread(threadSafeMap, values);

        Thread sumThread = sumHashMapIntegersThread(threadSafeMap);

        addThread.start();
        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addHashMapIntegersThread(HashMap<Integer, Integer> threadSafeMap,
            int[] values) {
        return new Thread(() -> {
            for (int i = 0; i < values.length; i++) {
                threadSafeMap.put(i, values[i]);
            }
        });
    }

    private static Thread sumHashMapIntegersThread(HashMap<Integer, Integer> threadSafeMap) {

        return new Thread(() -> {
            int sum = 0;
            try {
                for (Integer value : threadSafeMap.values()) {
                    sum += value;
                    Thread.sleep(1);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Caught ConcurrentModificationException");
            } catch (InterruptedException e) {
                System.out.println("Caught InterruptedException");
            }
            System.out.println("The Sum of the HashMap values is:" + sum);
        });

    }

}
