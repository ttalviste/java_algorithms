package com.unchecked.datastructures.linkedlist;


import com.unchecked.datastructures.linkedlist.iterators.ReverseIterable;
import com.unchecked.datastructures.linkedlist.iterators.ReverseIterator;

import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T>, Iterator<T>, ReverseIterable<T>, ReverseIterator<T> {
    private DoublyLinkedListNode<T> iteratorPointer;
    private DoublyLinkedListNode<T> reverseIteratorPointer;
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int count = 0;

    public DoublyLinkedListNode<T> getHead() {
        return head;
    }

    public DoublyLinkedListNode<T> getTail() {
        return tail;
    }

    public void addHead(T value) {
        DoublyLinkedListNode<T> adding = new DoublyLinkedListNode<>(value, null, this.head);

        if (Objects.nonNull(head)) {
            head.setPrevious(adding);
        }
        head = adding;
        if (Objects.isNull(tail)) {
            tail = head;
        }
        count++;
        resetIteratorPointers();

    }

    public void addTail(T value) {
        if (Objects.isNull(tail)) {
            this.addHead(value);
        } else {
            DoublyLinkedListNode<T> adding = new DoublyLinkedListNode<>(value, this.head, null);
            tail.setNext(adding);
            tail = adding;
            count++;
        }
        resetIteratorPointers();

    }


    @Override
    public void remove() {
        Iterator.super.remove();
    }

    public boolean remove(T value) {
        DoublyLinkedListNode<T> found = find(value);
        if (Objects.isNull(found)) {
            return false;
        }

        DoublyLinkedListNode<T> previous = found.getPrevious();
        DoublyLinkedListNode<T> next = found.getNext();

        if (Objects.isNull(previous)) {
            this.head = next;
            if (Objects.nonNull(this.head)) {
                this.head.setPrevious(null);
            }
        } else {
            previous.setNext(next);
        }

        if (Objects.isNull(next)) {
            this.tail = previous;
            if (Objects.nonNull(this.tail)) {
                this.tail.setNext(null);
            }
        } else {
            next.setPrevious(previous);
        }

        count--;
        resetIteratorPointers();
        return true;
    }


    public int getCount() {
        return count;
    }

    private DoublyLinkedListNode<T> find(T value) {
        DoublyLinkedListNode<T> current = getHead();

        while (Objects.nonNull(current)) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean Contains(T value) {
        return Objects.nonNull(find(value));
    }

    @Override
    public Iterator<T> iterator() {
        resetIteratorPointers();
        return this;
    }


    @Override
    public boolean hasNext() {
        return iteratorPointer != null;
    }

    @Override
    public T next() {
        T data = iteratorPointer.getValue();
        iteratorPointer = iteratorPointer.getNext();
        return data;
    }

    @Override
    public ReverseIterator<T> reverseIterator() {
        resetIteratorPointers();
        return this;
    }

    @Override
    public boolean hasPreviuos() {
        return reverseIteratorPointer != null;
    }

    @Override
    public T previous() {
        T data = reverseIteratorPointer.getValue();
        reverseIteratorPointer = reverseIteratorPointer.getPrevious();
        return data;
    }

    private void resetIteratorPointers() {
        iteratorPointer = this.head;
        reverseIteratorPointer = this.tail;
    }
}
