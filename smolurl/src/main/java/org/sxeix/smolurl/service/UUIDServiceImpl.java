package org.sxeix.smolurl.service;

import org.springframework.stereotype.Service;
import org.sxeix.exception.ParameterValidationException;
import org.sxeix.generator.UUIDGen;
import org.sxeix.smolurl.exception.UrlShortenException;

import java.util.UUID;

import static org.sxeix.smolurl.constants.UUIDConstants.UUID_V5_NAMESPACE;

@Service
public class UUIDServiceImpl implements UUIDService {

    @Override
    public UUID makeUUID(final String value) throws UrlShortenException {
        try {
            return UUIDGen.makeUUIDv5(UUID_V5_NAMESPACE, value.getBytes());
         } catch (ParameterValidationException e) {
            throw new UrlShortenException(String.format("Invalid value, cannot be shortened: %s", value));
        }
    }

}
