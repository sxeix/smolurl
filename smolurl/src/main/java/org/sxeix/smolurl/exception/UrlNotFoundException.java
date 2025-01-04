package org.sxeix.smolurl.exception;

/**
 * Exception for when the Url record cannot be found
 */
public class UrlNotFoundException extends Exception {
    public UrlNotFoundException(final String message) {
        super(message);
    }
}
