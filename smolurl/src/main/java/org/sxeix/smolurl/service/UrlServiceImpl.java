package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.smolurl.model.Url;
import org.sxeix.smolurl.repository.UrlRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url insert(Url url) {
        return urlRepository.insert(url);
    }

    @Override
    public Optional<Url> findById(UUID id) {
        return urlRepository.findById(id);
    }
}
