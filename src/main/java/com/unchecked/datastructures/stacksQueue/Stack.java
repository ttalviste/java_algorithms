package com.unchecked.datastructures.stacksQueue;

import java.util.Objects;

public class Stack<T> {

    private final Deque<T> store = new Deque<T>();

    public void push(T value) {
        store.enqueueHead(value);
    }

    public T pop() {
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
