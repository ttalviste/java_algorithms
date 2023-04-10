package com.unchecked.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void should_create_empty_list() {
        DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>();
        assertEquals(0, emptyList.getCount());
    }

    @Test
    void should_add_head_correctly() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);

        }

        int expected = 5;
        for (Integer actual :
                ints) {
            assertEquals(expected--, actual);
        }

    }

    @Test
    void should_add_tail_correctly() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addTail(i);
            assertEquals(i, ints.getCount());
        }

        int expected = 1;
        for (Integer actual : ints) {
            assertEquals(expected++, actual);
        }

    }

    @Test
    void contains_test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addTail(i);
        }

        assertTrue(ints.contains(1));
        assertFalse(ints.contains(7));

    }

    @Test
    void remove_head_test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        assertTrue(ints.remove(1));
        assertEquals(4, ints.getCount());


    }

    @Test
    void remove_tail_test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        assertTrue(ints.remove(5));
        assertEquals(4, ints.getCount());


    }

    @Test
    void remove_from_empty_test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();


        assertFalse(ints.remove(1));
        assertEquals(0, ints.getCount());


    }

    @Test
    void remove_from_middle_test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        assertTrue(ints.remove(3));
        assertEquals(4, ints.getCount());


    }

    @Test
    void given_ints_should_iterate_forward() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        int expected = 5;
        while (ints.hasNext()) {
            assertEquals(expected--, ints.next());
        }
    }

    @Test
    void given_ints_should_iterate_in_reverse() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        int expected = 1;
        while (ints.hasPreviuos()) {
            assertEquals(expected++, ints.previous());
        }
    }


    @Test
    void given_ints_remove_head_should_remove_head() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        ints.removeHead();

        int expected = 4;
        assertEquals(expected, ints.getCount());
        while (ints.hasNext()) {
            assertEquals(expected--, ints.next());
        }
    }

    @Test
    void given_ints_remove_tail_should_remove_tail() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
        }

        ints.removeTail();
        assertEquals(4, ints.getCount());

        int expected = 2;
        while (ints.hasPreviuos()) {
            assertEquals(expected++, ints.previous());
        }
    }


}