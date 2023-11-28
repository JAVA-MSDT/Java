package com.javamsdt.entity;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {
    private final LinkedBlockingQueue<T> pool = new LinkedBlockingQueue<>();

    public T get() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void take(T object) {
        try {
            pool.put(object);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Queue<T> getPool() {
        return this.pool;
    }
}
