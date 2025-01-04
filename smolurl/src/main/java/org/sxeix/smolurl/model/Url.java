package org.sxeix.smolurl.model;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Url {

    @Id
    private UUID id;
    private String url;

    public Url(UUID id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
