package com.javamsdt.customcthreadmap.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreadSafeMapWithSync<K, V> {

    private final Map<K, V> map = new HashMap<>();

    public synchronized void add(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized Set<K> getKeySet() {
        return new HashSet<>(map.keySet());
    }
    public synchronized Collection<V> values() {
        return new ArrayList<>(map.values());

    }

}
