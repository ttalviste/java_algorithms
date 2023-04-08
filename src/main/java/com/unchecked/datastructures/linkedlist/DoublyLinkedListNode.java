package com.unchecked.datastructures.linkedlist;

public class DoublyLinkedListNode<T> {

    private T value;
    private DoublyLinkedListNode<T> next;
    private DoublyLinkedListNode<T> previous;

    public DoublyLinkedListNode(T value, DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next) {

        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }


}
