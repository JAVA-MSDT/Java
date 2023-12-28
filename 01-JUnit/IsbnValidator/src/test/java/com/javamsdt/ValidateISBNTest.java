package com.javamsdt;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateISBNTest {

    private final ValidateISBN validateISBN = new ValidateISBN();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
     void checkValidISBN() {
        boolean isValidISBN =  validateISBN.checkISBN(140449116);
        assertTrue(isValidISBN);

         isValidISBN =  validateISBN.checkISBN(140177369);
        assertTrue(isValidISBN);
    }

    @Test
     void checkInValidISBN() {
        boolean isValidISBN =  validateISBN.checkISBN(140449117);
        assertFalse(isValidISBN);
    }
}