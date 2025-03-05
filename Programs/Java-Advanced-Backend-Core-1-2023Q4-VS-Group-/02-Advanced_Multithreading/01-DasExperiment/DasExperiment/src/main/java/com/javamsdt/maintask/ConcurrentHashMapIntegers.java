package com.javamsdt.maintask;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class ConcurrentHashMapIntegers {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

        Thread addThread = addConcurrentMapIntegersThread(concurrentMap);
        Thread sumThread = sumConcurrentMapIntegersThread(concurrentMap);

        addThread.start();
        Thread.sleep(2000);
        sumThread.start();


        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addConcurrentMapIntegersThread(ConcurrentHashMap<Integer, Integer> concurrentMap) {
        return new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                concurrentMap.put(i, i);
            }
        });
    }

    private static Thread sumConcurrentMapIntegersThread(ConcurrentHashMap<Integer, Integer> concurrentMap) {

        return new Thread(() -> {
            int sum = 0;
            for (Integer entry : concurrentMap.values()) {
                sum += entry;

            }
            System.out.println("The Sum on the ConcurrentHashMap values is:" + sum);
        });
    }

}
