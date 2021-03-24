package com.test.testdesarrolladores.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UriConfig {

    @Value("${uri.getCollection}")
    private String getCollection;

    public UriConfig() {
    }

    public String getGetCollection() {
        return getCollection;
    }

    public UriConfig setGetCollection(String getCollection) {
        this.getCollection = getCollection;
        return this;
    }
}
