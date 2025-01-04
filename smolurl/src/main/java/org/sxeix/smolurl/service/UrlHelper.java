package org.sxeix.smolurl.service;

import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.sxeix.smolurl.exceptions.UrlShortenException;

import java.net.URI;
import java.util.UUID;

public interface UrlHelper {
    CreatedUrl createShortUrl(RawUrl rawUrl) throws UrlShortenException;
    URI resolveUrl(UUID uuid);
}
