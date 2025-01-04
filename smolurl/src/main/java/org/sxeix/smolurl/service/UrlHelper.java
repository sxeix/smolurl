package org.sxeix.smolurl.service;

import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;

import java.net.URI;
import java.util.UUID;

public interface UrlHelper {
    CreatedUrl createShortUrl(RawUrl rawUrl);
    URI resolveUrl(UUID uuid);
}
