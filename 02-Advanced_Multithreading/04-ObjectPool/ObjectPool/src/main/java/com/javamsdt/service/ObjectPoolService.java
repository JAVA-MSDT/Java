package com.javamsdt.service;

import com.javamsdt.entity.ObjectPool;

public class ObjectPoolService{

    public void writeIntegersToPool(ObjectPool<Integer> objectPool, int size) {
        for (int i = 0; i < size; i++) {
            objectPool.take(i);
        }
        System.out.println("Done writing to Object Pool using Thread " + Thread.currentThread().getId());

    }

    public void readingIntegersFromPool(ObjectPool<Integer> objectPool) {
        objectPool.getPool().forEach(
                (object) -> System.out.println("Reading Integer #" + object)

        );
        System.out.println("Done reading to Object Pool using Thread " + Thread.currentThread().getId());
    }
}
