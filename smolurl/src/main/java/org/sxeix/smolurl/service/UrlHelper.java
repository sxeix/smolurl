package org.sxeix.smolurl.service;

import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.sxeix.smolurl.exception.UrlNotFoundException;
import org.sxeix.smolurl.exception.UrlShortenException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * Url Helper interface
 */
public interface UrlHelper {
    CreatedUrl createShortUrl(RawUrl rawUrl) throws UrlShortenException;
    URI resolveUrl(UUID uuid) throws UrlNotFoundException, URISyntaxException;
}
