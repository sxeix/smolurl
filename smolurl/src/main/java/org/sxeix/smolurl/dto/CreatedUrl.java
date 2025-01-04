package org.sxeix.smolurl.dto;

import java.util.UUID;

/**
 * Represents the result of a created Url record
 *
 * @param id the uuid created
 */
public record CreatedUrl(
        UUID id
) {
}
