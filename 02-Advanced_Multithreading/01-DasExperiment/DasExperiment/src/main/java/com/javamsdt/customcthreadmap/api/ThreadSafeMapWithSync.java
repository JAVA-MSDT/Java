package com.javamsdt.customcthreadmap.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeMapWithSync <K, V> {

    private final Map<K, V> map = new HashMap<>();

    public synchronized V put(K key, V value) {
        return map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized Collection<V> values() {
        return map.values();
    }
}
