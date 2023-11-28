package com.MVSTask.headerinfo.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.AccessToken;
import com.sun.mail.smtp.SMTPTransport;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


/**
 * A service class for sending emails with OAuth2.0
 */
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public static boolean sendEmail(String to, String subject, String content) {
        final String from = "asadahmed1592@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");

        // Fetch OAuth2.0 access token
        String accessToken = getAccessToken();

        if (accessToken == null) {
            logger.error("Failed to get access token");
            return false;
        }

        Session session = Session.getInstance(properties);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");
            transport.connect("smtp.gmail.com", from, accessToken);
            transport.sendMessage(message, message.getAllRecipients());

            logger.info("Email sent successfully to {}", to);
            return true;
        } catch (MessagingException e) {
            logger.error("Failed to send email", e);
            return false;
        }
    }

    private static String getAccessToken() {
        try {
            // Load client ID and secret from a file or environment variables, etc.
            // You need to replace the following line accordingly
            GoogleCredentials credentials = GoogleCredentials.fromStream(
                            new FileInputStream("G:\\Jobs Recruitement Task\\Materna Virtual Solution\\MVSTask\\src\\main\\resources\\com\\MVSTask\\headerinfo\\serviceAccountKey\\maternavirtualsolutiontask-145f97804f09.json"))
                    .createScoped("https://www.googleapis.com/auth/gmail.send");

            credentials.refreshIfExpired();
            AccessToken token = credentials.getAccessToken();

            return token.getTokenValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
