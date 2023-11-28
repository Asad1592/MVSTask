package com.MVSTask.headerinfo.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailValidatorTest {

    @Test
    public void testValidEmail() {
        assertTrue(EmailValidator.isValidEmail("test@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(EmailValidator.isValidEmail("invalid-email"));
    }

    @Test
    public void testNullEmail() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}
