package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {

        ExceptionThrower obj = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            obj.throwException();
        });

    }
}   