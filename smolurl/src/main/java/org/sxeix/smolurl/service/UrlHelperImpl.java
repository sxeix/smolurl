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

/**
 * Url Helper service
 */
@Service
public class UrlHelperImpl implements UrlHelper {

    private final UUIDService uuidService;
    private final UrlService urlService;

    public UrlHelperImpl(
            final UUIDService uuidService,
            final UrlService urlService
    ) {
        this.uuidService = uuidService;
        this.urlService = urlService;
    }

    /**
     * Creates a short url (UUIDv5 resolvable id)
     *
     * @param rawUrl the url to be shortened
     * @return UUIDv5 resolvable id
     * @throws UrlShortenException something went wrong shortening the url
     */
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

    /**
     * Resolves a UUIDv5 to the corresponding url
     *
     * @param uuid the UUIDv5 to be resolved
     * @return the URI to be redirected to
     * @throws UrlNotFoundException the Url could not be found as a document
     * @throws URISyntaxException   the Url found from the UUIDv5 is not a valid URI
     */
    @Override
    public URI resolveUrl(final UUID uuid) throws UrlNotFoundException, URISyntaxException {

        var url = urlService.findById(uuid).orElseThrow(() -> new UrlNotFoundException(String.format("Url not found for uuid %s", uuid)));
        return new URI(url.getUrl());
    }

}
