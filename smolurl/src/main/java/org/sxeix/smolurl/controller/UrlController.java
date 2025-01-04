package org.sxeix.smolurl.controller;

import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sxeix.smolurl.service.UrlHelper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
public class UrlController {

    private final UrlHelper urlHelper;

    private UrlController(UrlHelper urlHelper) {
        this.urlHelper = urlHelper;
    }

    @PostMapping(
            value = "/create"
    )
    public ResponseEntity<CreatedUrl> create(@RequestBody final RawUrl rawUrl) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<Void> resolve(@PathVariable("id") final UUID uuid) throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.SEE_OTHER).location(new URI("https://www.google.co.uk/")).build();
    }

}
