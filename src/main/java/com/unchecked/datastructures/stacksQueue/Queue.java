package com.unchecked.datastructures.stacksQueue;

import java.util.Objects;

public class Queue<T> {
    private final Deque<T> store = new Deque<T>();

    public void enqueue(T value) {
        store.enqueueTail(value);
    }

    public T dequeue() {
        return store.dequeueHead();
    }

    public T peek() {
        T value = store.peekHead();
        if (Objects.nonNull(value)) {
            return value;
        }
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return store.getCount();
    }
}
