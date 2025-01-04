package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.sxeix.smolurl.exception.UrlNotFoundException;
import org.sxeix.smolurl.exception.UrlShortenException;
import org.sxeix.smolurl.model.Url;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Service
public class UrlHelperImpl implements UrlHelper {

    private final UUIDService uuidService;
    private final UrlService urlService;

    public UrlHelperImpl(UUIDService uuidService, UrlService urlService) {
        this.uuidService = uuidService;
        this.urlService = urlService;
    }

    @Override
    public CreatedUrl createShortUrl(final RawUrl rawUrl) throws UrlShortenException {

        var uuid = uuidService.makeUUID(rawUrl.url());
        var url = urlService.findById(uuid);
        if (url.isPresent()) {
            return new CreatedUrl(uuid);
        }
        var insertedUrl = urlService.insert(new Url(uuid, rawUrl.url()));
        if (insertedUrl == null) {
            throw new UrlShortenException("Failed to create new url record");
        }
        return new CreatedUrl(uuid);
    }

    @Override
    public URI resolveUrl(final UUID uuid) throws UrlNotFoundException, URISyntaxException {

        var url = urlService.findById(uuid).orElseThrow(() -> new UrlNotFoundException(String.format("Url not found for uuid %s", uuid)));
        return new URI(url.getUrl());
    }

}
