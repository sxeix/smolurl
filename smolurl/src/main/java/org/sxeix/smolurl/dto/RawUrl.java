package org.sxeix.smolurl.dto;

import java.net.URI;

/**
 * Represents the raw url provided by the client
 *
 * @param url the raw url
 */
public record RawUrl(
        URI url
) {
}
