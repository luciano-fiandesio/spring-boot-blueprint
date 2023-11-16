package com.springboot.blueprint.controller;

import com.springboot.blueprint.model.EntityVersion;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class RestResourceController {


    protected <T> ResponseEntity<T> withVersion(Pair<T, EntityVersion> pair) {
        return withVersion(pair, HttpStatus.OK);
    }

    protected <T> ResponseEntity<T> withVersion(Pair<T, EntityVersion> pair, HttpStatus status) {

        return ResponseEntity
                .status(status)
                .eTag(pair.getSecond().version().toString())
                // This is required when using CORS, otherwise the client is unable to access the ETag header
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "ETag")
                .body(pair.getFirst());
    }

}
