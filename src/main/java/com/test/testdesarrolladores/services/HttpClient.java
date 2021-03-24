package com.test.testdesarrolladores.services;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpClient {
    HttpResponse<?> doPost(HttpRequest request) throws IOException, InterruptedException;

    HttpResponse<String> doGet(HttpRequest request) throws IOException, InterruptedException;
}
