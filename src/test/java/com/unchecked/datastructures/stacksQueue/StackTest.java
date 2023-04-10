package com.unchecked.datastructures.stacksQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    void numbers_are_pushed() {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            integerStack.push(i);
        }

        assertEquals(5, integerStack.peek());
    }

    @Test
    void numbers_are_popped() {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            integerStack.push(i);
        }

        int expected = 5;
        for (int i = 0; i < 5; i++) {
            assertEquals(expected--, integerStack.pop());
        }
    }


    @Test
    void give_queue_count_is_correct() {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            integerStack.push(i);
        }
        assertEquals(5, integerStack.getCount());
    }

}