package org.sxeix.smolurl.service;

import org.sxeix.smolurl.exception.UrlShortenException;

import java.util.UUID;

public interface UUIDService {
    UUID makeUUID(String value) throws UrlShortenException;
}
