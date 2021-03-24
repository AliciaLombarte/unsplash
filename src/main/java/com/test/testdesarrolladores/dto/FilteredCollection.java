package com.test.testdesarrolladores.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilteredCollection implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String cover_photo_id;

    public FilteredCollection() {
    }

    public FilteredCollection(String description) {
        this.description = description;
    }

    @JsonProperty("cover_photo")
    private void unpackNested(Map<String, Object> coverPhoto) {
        this.cover_photo_id = (String) coverPhoto.get("id");
    }

    public Integer getId() {
        return id;
    }

    public FilteredCollection setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilteredCollection setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilteredCollection setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCover_photo_id() {
        return cover_photo_id;
    }

    public FilteredCollection setCover_photo_id(String cover_photo_id) {
        this.cover_photo_id = cover_photo_id;
        return this;
    }
}
