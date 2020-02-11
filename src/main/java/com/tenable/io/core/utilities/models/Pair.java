package com.tenable.io.core.utilities.models;


import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Pair<K,V> implements Serializable {
    private static final long serialVersionUID = 1L;

    private K key;

    public K getKey() { return key; }

    private V value;

    public V getValue() { return value; }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
