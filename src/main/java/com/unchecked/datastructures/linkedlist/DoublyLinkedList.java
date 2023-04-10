package com.unchecked.datastructures.linkedlist;


import com.unchecked.datastructures.linkedlist.iterators.ReverseIterable;
import com.unchecked.datastructures.linkedlist.iterators.ReverseIterator;

import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList<T> implements Iterable<T>, Iterator<T>, ReverseIterable<T>, ReverseIterator<T> {
    private DoublyLinkedListNode<T> iteratorPointer;
    private DoublyLinkedListNode<T> reverseIteratorPointer;
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int count = 0;


    public void addHead(T value) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(value, null, null);
        DoublyLinkedListNode<T> temp = head;

        // Point head to the new node
        head = node;

        // Insert the rest of the list behind the head
        head.setNext(temp);

        if (getCount() == 0) {
            // if the list was empty then Head and Tail should
            // both point to the new node.
            tail = head;
        } else {
            // Before: Head -------> 5 <-> 7 -> null
            // After:  Head -> 3 <-> 5 <-> 7 -> null

            // temp.Previous was null, now Head
            temp.setPrevious(head);
            ;
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

    public void removeHead() {
        if (getCount() != 0) {
            // Before: Head -> 3 <-> 5
            // After:  Head -------> 5

            // Head -> 3 -> null
            // Head ------> null
            head = head.getNext();

            count--;

            if (getCount() == 0) {
                tail = null;
            } else {
                // 5.Previous was 3, now null
                head.setPrevious(null);
            }
        }
        resetIteratorPointers();
    }

    public void removeTail() {
        if (getCount() != 0) {
            if (getCount() == 1) {
                head = null;
                tail = null;
            } else {
                // Before: Head --> 3 --> 5 --> 7
                //         Tail = 7
                // After:  Head --> 3 --> 5 --> null
                //         Tail = 5
                // Null out 5's Next pointer
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
            }

            count--;
        }
        resetIteratorPointers();
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
        DoublyLinkedListNode<T> current = head;

        while (Objects.nonNull(current)) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean contains(T value) {
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

    public T getHead() {
        if (this.getCount() > 0) {
            return head.getValue();
        }

        return null;
    }

    public T getTail() {
        if (this.getCount() > 0) {

            return this.tail.getValue();
        }
        return null;
    }
}
