package org.sxeix.smolurl.service;

import org.sxeix.smolurl.exception.UrlShortenException;

import java.util.UUID;

/**
 * UUID service for creating UUIDs
 */
public interface UUIDService {
    UUID makeUUID(String value) throws UrlShortenException;
}
