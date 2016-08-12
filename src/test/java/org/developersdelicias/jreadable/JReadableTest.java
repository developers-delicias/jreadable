package org.developersdelicias.jreadable;

import org.junit.jupiter.api.Test;

import static org.developersdelicias.jreadable.JReadable.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JReadableTest {

    private static final Object FOO = new Object();
    private static final Object BAR = new Object();

    @Test
    void inform_when_a_number_is_between_two_numbers() {
        assertTrue(valueOf(8).isBetween(5).and(10), "Should return true because 8 is between 5 and 10");
    }

    @Test
    void inform_when_a_number_is_between_two_numbers_ignoring_order() {
        assertTrue(valueOf(8).isBetween(10).and(5), "Should return true because 8 is between 5 and 10 even order is inverted");
    }

    @Test
    void inform_when_a_number_is_not_between_two_numbers() {
        assertFalse(valueOf(2).isBetween(5).and(10), "Should return false because 2 is not between 5 and 10");
    }

    @Test
    void inform_when_an_object_is_null() {
        assertTrue(object(null).isNull());
        assertFalse(object(FOO).isNull());
    }

    @Test
    void inform_when_an_object_is_not_null() {
        assertTrue(object(FOO).isNotNull());
        assertFalse(object(null).isNotNull());
    }

    @Test
    void inform_when_two_objects_are_equal() {
        assertTrue(object(FOO).isEqualsTo(FOO));
        assertFalse(object(FOO).isEqualsTo(BAR));
    }

    @Test
    void inform_when_two_objects_are_not_equal() {
        assertTrue(object(FOO).isNotEqualTo(BAR));
        assertFalse(object(FOO).isNotEqualTo(FOO));
    }

    @Test
    void inform_when_a_string_is_a_number() {
        assertTrue(string("12345").isNumeric(), "12345 should be numeric");
        assertTrue(string("12.00").isNumeric(), "12.00 should be numeric");
    }

    @Test
    void inform_when_a_string_is_not_a_number() {
        assertTrue(string(null).isNotNumeric());
        assertTrue(string("not a string").isNotNumeric(), "Should not be numeric");

        assertFalse(string("not a string").isNumeric(), "Should not be numeric");
        assertFalse(string(null).isNumeric(), "Should not be numeric");
    }
}
