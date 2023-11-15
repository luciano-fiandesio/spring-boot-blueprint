package com.springboot.blueprint.repository;

import com.springboot.blueprint.entities.InstructorJpa;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorJpaRepository extends BaseJpaRepository<InstructorJpa, Long> {
}