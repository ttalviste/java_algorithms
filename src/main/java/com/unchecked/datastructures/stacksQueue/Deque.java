package com.unchecked.datastructures.stacksQueue;

import com.unchecked.datastructures.linkedlist.DoublyLinkedList;

import java.util.Iterator;
import java.util.Objects;

public class Deque<T> implements Iterable<T>, Iterator<T> {
    private final DoublyLinkedList<T> store;

    public Deque() {
        store = new DoublyLinkedList<T>();
    }

    public void enqueueHead(T value) {
        store.addHead(value);
    }

    public void enqueueTail(T value) {
        store.addTail(value);
    }


    public T dequeueHead() {
        T value = store.getHead();
        if (Objects.nonNull(value)) {
            store.removeHead();
            return value;
        }
        throw new UnsupportedOperationException();

    }


    public T dequeueTail() {
        T value = store.getTail();
        if (Objects.nonNull(value)) {
            store.removeTail();
            return value;
        }
        throw new UnsupportedOperationException();
    }


    public T peekHead() {
        T value = store.getHead();
        if (Objects.nonNull(value)) {
            return value;
        }
        throw new UnsupportedOperationException();

    }


    public T peekTail() {
        T value = store.getTail();
        if (Objects.nonNull(value)) {
            return value;
        }
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return store.getCount();
    }

    @Override
    public Iterator<T> iterator() {
        return store.iterator();
    }

    @Override
    public boolean hasNext() {
        return store.hasNext();
    }

    @Override
    public T next() {
        return store.next();
    }
}
