package com.javamsdt.maintask;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HashMapIntegers {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Thread addThread = addHashMapIntegersThread(hashMap);
        Thread sumThread = sumHashMapIntegersThread(hashMap);

        addThread.start();
        sumThread.start();

        addThread.join();
        sumThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " milliseconds");
    }

    private static Thread addHashMapIntegersThread(HashMap<Integer, Integer> hashMap) {
        return new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                hashMap.put(i, i);
            }
        });
    }

    private static Thread sumHashMapIntegersThread(HashMap<Integer, Integer> hashMap) {

        return new Thread(() -> {
            int sum = 0;
            try {
                for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                    sum += entry.getValue();
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Caught ConcurrentModificationException during the Sum operation");
            }

            System.out.println("The Sum of the HashMap values is:" + sum);
        });

    }

}
