package org.sxeix.smolurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.sxeix.smolurl.model.Url;

import java.util.UUID;

/**
 * Url mongodb repository interface
 */
public interface UrlRepository extends MongoRepository<Url, UUID> {
}
