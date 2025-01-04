package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.smolurl.model.Url;
import org.sxeix.smolurl.repository.UrlRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Url service for managing the repository
 */
@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(final UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    /**
     * Inserts a new Url record
     *
     * @param url the url record
     * @return the inserted url record
     */
    @Override
    public Url insert(final Url url) {
        return urlRepository.insert(url);
    }

    /**
     * Finds a record by the UUIDv5
     *
     * @param id the UUIDv5
     * @return an Optional
     */
    @Override
    public Optional<Url> findById(final UUID id) {
        return urlRepository.findById(id);
    }
}
