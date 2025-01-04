package org.sxeix.smolurl.service;

import org.sxeix.smolurl.model.Url;

import java.util.Optional;
import java.util.UUID;

/**
 * Url service for managing the URL model
 */
public interface UrlService {
    Url insert(Url url);
    Optional<Url> findById(UUID id);
}
