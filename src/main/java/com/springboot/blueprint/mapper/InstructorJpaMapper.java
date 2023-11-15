package com.springboot.blueprint.mapper;

import com.springboot.blueprint.api.model.Instructor;
import com.springboot.blueprint.entities.InstructorJpa;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {MetaMapper.class}
)
public interface InstructorJpaMapper {

    @ToEntity
    InstructorJpa toEntity(Instructor instructor);

    @Mapping(target = "meta", source = ".")
    Instructor toDto(InstructorJpa instructorJpa);

    //@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    //InstructorJpa partialUpdate(Instructor instructor, @MappingTarget InstructorJpa instructorJpa);
}