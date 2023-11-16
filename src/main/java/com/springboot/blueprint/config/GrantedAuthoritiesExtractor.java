package com.springboot.blueprint.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class GrantedAuthoritiesExtractor implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final JwtMappingProperties mappingProps;
    private final static String DEFAULT_ROLES_ATTR = "roles";

    public Collection<GrantedAuthority> convert(Jwt jwt) {
        return (
                (Map<String, Collection<?>>) jwt.getClaims().getOrDefault(mappingProps.getAuthoritiesClaimName(), Collections.emptyMap())
        ).getOrDefault(DEFAULT_ROLES_ATTR, Collections.emptyList())
                .stream()
                .map(Object::toString)
                .map(SimpleGrantedAuthority::new)
                //.peek(authority -> log.info("Granted Authority: " + authority.getAuthority()))
                .collect(Collectors.toList());
    }
}
