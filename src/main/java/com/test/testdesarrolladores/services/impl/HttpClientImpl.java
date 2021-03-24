package com.test.testdesarrolladores.services.impl;

import com.test.testdesarrolladores.services.HttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class HttpClientImpl implements HttpClient {
    @Override
    public HttpResponse<?> doPost(HttpRequest request) throws IOException, InterruptedException {

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> doGet(HttpRequest request) throws IOException, InterruptedException {
        java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder()
                .version(java.net.http.HttpClient.Version.HTTP_2)
                .followRedirects(java.net.http.HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
