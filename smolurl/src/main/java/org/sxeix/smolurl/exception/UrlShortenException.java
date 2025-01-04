package org.sxeix.smolurl.exception;

/**
 * Exception for when the url fails to be shortened
 */
public class UrlShortenException extends Exception {
    public UrlShortenException(final String message) {
        super(message);
    }
}
