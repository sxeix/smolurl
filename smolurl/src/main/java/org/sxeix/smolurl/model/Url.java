package org.sxeix.smolurl.model;

import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * Represents a Url document
 */
public record Url(
        @Id UUID id,
        String url
) {
}
