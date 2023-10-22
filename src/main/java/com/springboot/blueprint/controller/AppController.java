package com.springboot.blueprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
//@RequiredArgsConstructor
public class AppController {

    private final BuildProperties buildProperties;

    public AppController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping(value = "/build")
    //@PreAuthorize("isAuthenticated()")
    public BuildProperties getAppVersion() {
        return buildProperties;
    }
}
