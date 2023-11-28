package com.MVSTask.headerinfo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import jakarta.mail.MessagingException;

public class EmailServiceTest {

    @Test
    public void testSendEmailSuccess() throws MessagingException {
        EmailService emailService = Mockito.spy(EmailService.class);
        Mockito.doNothing().when(emailService).sendEmail(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
        assertTrue(emailService.sendEmail("test@example.com", "Test", "Test Content"));
    }

    @Test
    public void testSendEmailFailure() throws MessagingException {
        EmailService emailService = Mockito.spy(EmailService.class);
        Mockito.doThrow(new MessagingException("error")).when(emailService).sendEmail(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
        assertFalse(emailService.sendEmail("test@example.com", "Test", "Test Content"));
    }
}
