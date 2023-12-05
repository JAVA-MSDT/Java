package com.javamsdt.configuration;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingObjectPool {
    private final Queue<Object> pool;
    private final int size;
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public BlockingObjectPool(int size) {
        this.size = size;
        this.pool = new LinkedList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < size; i++) {
            pool.offer(new Object());
        }
    }

    public synchronized Object get() {
        if (pool.isEmpty()) {
            System.err.println("Error in Thread# " + Thread.currentThread().getId() + ", the pool is empty");
            try {
                System.err.println("Error in Thread# " + Thread.currentThread().getId() + ", the pool is empty");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return pool.poll();
    }

    public synchronized void take(Object object) {

        if (pool.size() >= size) {
            System.err.println("Error in Thread# " + Thread.currentThread().getId() + ", the pool is already full of Objects");
            try {
                System.err.println("Error in Thread# " + Thread.currentThread().getId() + ", the pool is already full of Objects");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pool.offer(object);
        notify();
    }
}
