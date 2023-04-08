package com.unchecked.datastructures.linkedlist;

import com.unchecked.datastructures.linkedlist.iterators.ReverseIterable;
import com.unchecked.datastructures.linkedlist.iterators.ReverseIterator;

import java.util.Iterator;
import java.util.Objects;

public class SortedList<T extends Comparable<T>> implements Iterable<T>, Iterator<T>, ReverseIterable<T>, ReverseIterator<T> {
    public boolean contains(T value) {
        return Objects.nonNull(find(value));
    }

    private SortedListNode<T> find(T value) {
        SortedListNode<T> current = head;

        while (Objects.nonNull(current)) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    static class SortedListNode<TNode extends Comparable<TNode>> {
        public SortedListNode<TNode> prev;
        public SortedListNode<TNode> next;
        private TNode value;

        SortedListNode(TNode value, SortedListNode<TNode> prev, SortedListNode<TNode> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private SortedListNode<T> head = null;
    private SortedListNode<T> tail = null;

    private SortedListNode<T> iteratorPointer;
    private SortedListNode<T> reverseIteratorPointer;
    private int count = 0;

    public int getCount() {
        return count;
    }


    public void add(T value) {
        if (Objects.isNull(head)) {
            head = new SortedListNode<>(value, null, null);
            tail = head;
        } else if (head.value.compareTo(value) >= 0) {
            SortedListNode<T> newHead = new SortedListNode<>(value, null, head);
            head.prev = newHead;
            head = newHead;
        } else if (tail.value.compareTo(value) < 0) {
            SortedListNode<T> newTail = new SortedListNode<>(value, tail, null);
            tail.next = newTail;
            tail = newTail;
        } else {
            SortedListNode<T> insertBefore = head;
            while (insertBefore.value.compareTo(value) < 0) {
                insertBefore = insertBefore.next;
            }

            // insert the node
            SortedListNode<T> toInsert = new SortedListNode<T>(value, insertBefore.prev, insertBefore);
            insertBefore.prev.next = toInsert;
            insertBefore.prev = toInsert;
        }
        count++;
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
        T data = reverseIteratorPointer.value;
        reverseIteratorPointer = reverseIteratorPointer.prev;
        return data;
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
        T data = iteratorPointer.value;
        iteratorPointer = iteratorPointer.next;
        return data;
    }

    private void resetIteratorPointers() {
        iteratorPointer = this.head;
        reverseIteratorPointer = this.tail;
    }


}
