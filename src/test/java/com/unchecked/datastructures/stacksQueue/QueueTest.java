package com.unchecked.datastructures.stacksQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {

    @Test
    void given_numbers_are_added_to_queue() {
        Queue<Integer> integerQueue = new Queue<>();
        for (int i = 1; i <= 5; i++) {
            integerQueue.enqueue(i);
        }

        assertEquals(1, integerQueue.peek());
    }

    @Test
    void given_queue_numbers_are_correctly_dequeued() {
        Queue<Integer> integerQueue = new Queue<>();
        for (int i = 1; i <= 5; i++) {
            integerQueue.enqueue(i);
        }

        int expected = 1;
        for (int i = 0; i < 5; i++) {
            assertEquals(expected++, integerQueue.dequeue());
        }
    }


    @Test
    void give_queue_count_is_correct() {
        Queue<Integer> integerQueue = new Queue<>();
        for (int i = 1; i <= 5; i++) {
            integerQueue.enqueue(i);
        }
        assertEquals(5, integerQueue.getCount());
    }
}