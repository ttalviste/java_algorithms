package com.unchecked.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedListTest {

    @Test
    void given_numbers_should_add() {
        SortedList<Integer> ints = new SortedList<>();

        ints.add(1);
        ints.add(4);
        ints.add(2);
        ints.add(5);
        ints.add(3);


        int expected = 1;
        for (Integer actual : ints) {
            assertEquals(expected++, actual);
        }
    }

    @Test
    void given_5_numbers_should_return_correct_count() {
        SortedList<Integer> ints = new SortedList<>();

        ints.add(1);
        ints.add(4);
        ints.add(2);
        ints.add(5);
        ints.add(3);

        assertEquals(5, ints.getCount());
    }

    @Test
    void given_numbers_validate_if_contains_value() {
        SortedList<Integer> ints = new SortedList<>();

        ints.add(1);

        assertTrue(ints.contains(1));
        assertFalse(ints.contains(2));
    }


}