package com.springboot.blueprint.service;

import com.springboot.blueprint.api.model.Instructor;
import com.springboot.blueprint.mapper.InstructorJpaMapper;
import com.springboot.blueprint.repository.InstructorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstructorService {

    private final InstructorJpaRepository instructorJpaRepository;
    private final InstructorJpaMapper instructorJpaMapper;

    @Transactional
    public Instructor createInstructor(Instructor instructor) {

        return instructorJpaMapper.toDto(instructorJpaRepository.persist(
                instructorJpaMapper.toEntity(instructor)));
    }

}
