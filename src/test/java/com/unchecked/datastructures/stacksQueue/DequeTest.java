package com.unchecked.datastructures.stacksQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeTest {

    @Test
    void add_item_to_deque_via_head() {
        Deque<Integer> ints = new Deque<>();
        for (int i = 1; i <= 5; i++) {
            ints.enqueueHead(i);
        }

        assertEquals(5, ints.peekHead());
        assertEquals(1, ints.peekTail());
    }

    @Test
    void add_item_to_deque_via_tail() {
        Deque<Integer> ints = new Deque<>();
        for (int i = 1; i <= 5; i++) {
            ints.enqueueTail(i);
        }

        assertEquals(1, ints.peekHead());
        assertEquals(5, ints.peekTail());
    }
}