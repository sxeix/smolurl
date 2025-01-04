package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.smolurl.dto.CreatedUrl;
import org.sxeix.smolurl.dto.RawUrl;

import java.net.URI;
import java.util.UUID;

@Service
public class UrlHelperImpl implements UrlHelper {

    @Override
    public CreatedUrl createShortUrl(RawUrl rawUrl) {
        return null;
    }

    @Override
    public URI resolveUrl(UUID uuid) {
        return null;
    }

}
