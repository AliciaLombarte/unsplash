package com.test.testdesarrolladores.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testdesarrolladores.config.UriConfig;
import com.test.testdesarrolladores.config.UserConfig;
import com.test.testdesarrolladores.dto.FilteredCollection;
import com.test.testdesarrolladores.services.CollectionService;
import com.test.testdesarrolladores.services.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    UserConfig userConfig;
    @Autowired
    UriConfig uriConfig;
    @Autowired
    HttpClient httpClient;

    @Override
    public List<FilteredCollection> getNonFilteredCollection() throws IOException, InterruptedException {
        HttpResponse<String> response = this.getCollection();
        return this.parseApiResponseBody(response.body());
    }

    @Override
    public List<FilteredCollection> getAndFilterCollection(String filterToApply) throws InterruptedException, IOException {
        HttpResponse<String> response = this.getCollection();
        return this.parseApiResponseBody(response.body())
                .stream()
                .map(given -> this.filterCollection(given, filterToApply))
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<FilteredCollection> parseApiResponseBody(String body) throws JsonProcessingException {
        return mapper.readValue(body, new TypeReference<List<FilteredCollection>>() {
        });
    }

    private FilteredCollection filterCollection(FilteredCollection collection, String filterToApply) {
        Map<String, String> mapResponse = mapper.convertValue(collection, new TypeReference<Map<String, String>>() {
        });

        ArrayList<String> listOfValues = new ArrayList<>(mapResponse.values());

        return listOfValues.stream()
                .filter(Objects::nonNull)
                .anyMatch(given -> given.toLowerCase().contains(filterToApply)) ? collection : null;
    }

    private HttpResponse<String> getCollection() throws InterruptedException, IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("access_token", userConfig.getUserAccessToken());
        String form = parameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriConfig.getGetCollection() + form))
                .GET()
                .header("accept", "application/json")
                .build();
        return httpClient.doGet(request);
    }

}
