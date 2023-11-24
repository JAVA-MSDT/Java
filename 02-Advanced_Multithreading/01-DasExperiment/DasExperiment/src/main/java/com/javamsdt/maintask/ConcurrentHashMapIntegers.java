package com.javamsdt.maintask;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class ConcurrentHashMapIntegers {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();
        int[] values = { 10, 15, 40, 30, 5 };
        Thread addThread = addConcurrentMapIntegersThread(concurrentMap, values);

        Thread sumThread = sumConcurrentMapIntegersThread(concurrentMap);

        addThread.start();
        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addConcurrentMapIntegersThread(ConcurrentHashMap<Integer, Integer> concurrentMap,
            int[] values) {
        return new Thread(() -> {
            for (int i = 0; i < values.length; i++) {
                concurrentMap.put(i, values[i]);
            }
        });
    }

    private static Thread sumConcurrentMapIntegersThread(ConcurrentHashMap<Integer, Integer> concurrentMap) {

        return new Thread(() -> {
            int sum = 0;
            for (Integer value : concurrentMap.values()) {
                sum += value;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The Sum on the ConcurrentHashMap values is:" + sum);
        });
    }

}
