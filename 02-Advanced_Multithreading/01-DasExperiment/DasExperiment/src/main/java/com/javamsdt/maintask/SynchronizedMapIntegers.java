package com.javamsdt.maintask;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SynchronizedMapIntegers {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Map<Integer, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());
        int[] values = { 10, 15, 40, 30, 5 };
        Thread addThread = addHashMapIntegersThread(hashMap, values);

        Thread sumThread = sumHashMapIntegersThread(hashMap);

        addThread.start();
        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addHashMapIntegersThread(Map<Integer, Integer> hashMap,
            int[] values) {
        return new Thread(() -> {
            for (int i = 0; i < values.length; i++) {
                hashMap.put(i, values[i]);
            }
        });
    }

    private static Thread sumHashMapIntegersThread(Map<Integer, Integer> hashMap) {

        return new Thread(() -> {
            int sum = 0;
            try {
                for (Integer value : hashMap.values()) {
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
