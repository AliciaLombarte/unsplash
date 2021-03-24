package com.test.testdesarrolladores.services;

import com.test.testdesarrolladores.dto.FilteredCollection;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public interface CollectionService {
    List<FilteredCollection> getNonFilteredCollection(String accessToken, String page, String size) throws IOException, InterruptedException;

    List<FilteredCollection> getAndFilterCollection(String accessToken, String filterToApply, String page, String size) throws InterruptedException, IOException, JSONException;
}
