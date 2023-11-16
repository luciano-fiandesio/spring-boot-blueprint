package com.springboot.blueprint.model;

public record EntityVersion(Long version) {
    public static EntityVersion of(Long version) {
        return new EntityVersion(version);
    }
}
