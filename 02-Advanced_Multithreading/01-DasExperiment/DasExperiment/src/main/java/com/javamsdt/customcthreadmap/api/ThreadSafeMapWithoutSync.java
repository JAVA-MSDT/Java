package com.javamsdt.customcthreadmap.api;

import java.util.HashMap;

public class ThreadSafeMapWithoutSync <K, V> extends HashMap<K, V> {
    @Override
    public V put(K key, V value) {
        synchronized (this) {
            return super.put(key, value);
        }
    }
}
