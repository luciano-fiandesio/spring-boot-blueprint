package com.springboot.blueprint.entities;

public interface VersionedEntity {

    Long getVersion();

    void setVersion(Long version);
}
