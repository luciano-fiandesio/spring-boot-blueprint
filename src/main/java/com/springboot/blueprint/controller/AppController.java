package com.springboot.blueprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

    private final BuildProperties buildProperties;

    @GetMapping(value = "/build")
    //@PreAuthorize("isAuthenticated()")
    public BuildProperties getAppVersion() {
        return buildProperties;
    }
}
