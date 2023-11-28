package com.MVSTask.headerinfo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for validating email addresses.
 */
public class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    /**
     * Validates the given email address.
     *
     * @param email the email address to validate
     * @return true if the email address is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
