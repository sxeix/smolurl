package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.sxeix.smolurl.exceptions.UrlShortenException;

import java.net.URI;
import java.util.UUID;

@Service
public class UrlHelperImpl implements UrlHelper {

    private final UUIDService uuidService;

    public UrlHelperImpl(UUIDService uuidService) {
        this.uuidService = uuidService;
    }

    @Override
    public CreatedUrl createShortUrl(final RawUrl rawUrl) throws UrlShortenException {

        var uuid = uuidService.makeUUID(rawUrl.url());

        // check for record
        // insert if not there

        return new CreatedUrl(uuid);
    }

    @Override
    public URI resolveUrl(final UUID uuid) {
        return null;
    }

}
