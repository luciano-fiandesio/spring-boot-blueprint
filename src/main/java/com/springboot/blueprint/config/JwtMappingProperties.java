package com.springboot.blueprint.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "app.jwt.mapping")
public class JwtMappingProperties {

    private String authoritiesPrefix;
    private String authoritiesClaimName;
    private String principalClaimName;
    private Map<String, String> scopes;
}
