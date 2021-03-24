package com.test.testdesarrolladores.controllers;

import com.test.testdesarrolladores.dto.FilteredCollection;
import com.test.testdesarrolladores.services.CollectionService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping(value = "/collections")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<List<FilteredCollection>> getFilteredCollections(
            @RequestParam(name = "access_token") String access_token,
            @RequestParam(name = "filter", required = false) String filterToApply,
            @RequestParam(value = "page", required = false, defaultValue = "0") String page,
            @RequestParam(value = "per_page", required = false, defaultValue = "10") String size) throws InterruptedException, NoSuchAlgorithmException, IOException, JSONException {
        if (filterToApply != null) {
            return ResponseEntity.ok().body(collectionService.getAndFilterCollection(access_token, filterToApply.toLowerCase(), page, size));
        } else {
            return ResponseEntity.ok().body(collectionService.getNonFilteredCollection(access_token, page, size));
        }
    }

}
