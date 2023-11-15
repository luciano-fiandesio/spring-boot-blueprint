package com.springboot.blueprint.mapper;

import com.springboot.blueprint.api.model.Meta;
import com.springboot.blueprint.entities.Auditable;
import com.springboot.blueprint.utils.TimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring"
)
public interface MetaMapper {

    @Mapping(source = "createdBy", target = "createdBy")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedBy", target = "updatedBy")
    @Mapping(source = "updatedAt", target = "updatedAt")
    Meta fromAuditable(Auditable hasMeta);

    default OffsetDateTime map(LocalDateTime localDateTime) {
        return TimeUtils.toUTCOffsetDateTime(localDateTime);
    }
}
