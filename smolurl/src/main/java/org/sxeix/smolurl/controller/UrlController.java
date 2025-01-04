package org.sxeix.smolurl.controller;

import org.springframework.http.MediaType;
import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sxeix.smolurl.exception.UrlNotFoundException;
import org.sxeix.smolurl.exception.UrlShortenException;
import org.sxeix.smolurl.service.UrlHelper;

import java.net.URISyntaxException;
import java.util.UUID;

/**
 * Controller for url based operations
 */
@RestController
public class UrlController {

    private final UrlHelper urlHelper;

    private UrlController(final UrlHelper urlHelper) {
        this.urlHelper = urlHelper;
    }

    /**
     * Creates a new key-value pair for UUID to url if one does not already exist.
     *
     * @param rawUrl the raw url the user wants to shorten
     * @return the uuid for the url
     * @throws UrlShortenException Url has been failed to be shortened
     */
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CreatedUrl> create(@RequestBody final RawUrl rawUrl) throws UrlShortenException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(urlHelper.createShortUrl(rawUrl));
    }

    /**
     * Resolves a UUID to the corresponding url
     *
     * @param uuid the UUID key
     * @return a redirect to the desired page
     * @throws URISyntaxException   URI for UUID is invalid
     * @throws UrlNotFoundException The URL record does not exist
     */
    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<Void> resolve(@PathVariable("id") final UUID uuid) throws URISyntaxException, UrlNotFoundException {

        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(urlHelper.resolveUrl(uuid))
                .build();
    }

}
