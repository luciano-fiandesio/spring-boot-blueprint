package com.springboot.blueprint.service;

import com.springboot.blueprint.api.model.Instructor;
import com.springboot.blueprint.mapper.InstructorJpaMapper;
import com.springboot.blueprint.model.EntityVersion;
import com.springboot.blueprint.repository.InstructorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstructorService {

    private final InstructorJpaRepository instructorJpaRepository;
    private final InstructorJpaMapper instructorJpaMapper;

    @Transactional
    public Pair<Instructor, EntityVersion> createInstructor(Instructor instructor) {
        var savedInstructor = instructorJpaRepository.persist(
                instructorJpaMapper.toEntity(instructor));
        return Pair.of(instructorJpaMapper.toDto(savedInstructor), EntityVersion.of(savedInstructor.getVersion()));
    }

}
