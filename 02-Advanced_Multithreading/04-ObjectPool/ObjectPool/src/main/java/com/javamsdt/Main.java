package com.javamsdt;

import com.javamsdt.entity.ObjectPool;
import com.javamsdt.service.ObjectPoolService;

public class Main {
    public static void main(String[] args) {

        ObjectPool<Integer> objectPool = new ObjectPool<>();
        ObjectPoolService poolService = new ObjectPoolService();



        Runnable writeToPool = () -> poolService.writeIntegersToPool(objectPool, 10);
        Runnable readFromPool = () -> poolService.readingIntegersFromPool(objectPool);


        Thread writeThread = new Thread(writeToPool);
        Thread readThread = new Thread(readFromPool);


        writeThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        readThread.start();

        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}