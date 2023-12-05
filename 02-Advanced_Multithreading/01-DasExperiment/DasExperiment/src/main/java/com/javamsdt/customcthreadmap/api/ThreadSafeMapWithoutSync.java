package com.javamsdt.customcthreadmap.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeMapWithoutSync<K, V> {

    private final Map<K, V> map = new HashMap<>();
    // private final Object lock = new Object();
    private final Lock lock = new ReentrantLock();

    public void put(K key, V value) {
        lock.lock();
        getMap().put(key, value);
        lock.unlock();
    }

    public V get(K key) {
        lock.lock();
        try {
            return getMap().get(key);
        } finally {
            lock.unlock();
        }
    }

    public Map<K, V> getMap() {
        lock.lock();
        try {
            return map;
        } finally {
            lock.unlock();
        }
    }

    public Set<K> keySet() {
        lock.lock();
        try {
            return new HashSet<>(map.keySet());
        } finally {
            lock.unlock();
        }
    }
}
