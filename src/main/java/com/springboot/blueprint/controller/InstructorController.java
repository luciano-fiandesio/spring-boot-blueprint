package com.springboot.blueprint.controller;

import com.springboot.blueprint.api.controller.InstructorsApi;
import com.springboot.blueprint.api.model.Instructor;
import com.springboot.blueprint.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController extends RestResourceController implements InstructorsApi {

    private final InstructorService instructorService;

    @Override
    public ResponseEntity<Instructor> createInstructor(Instructor instructor) {
        return withVersion(instructorService.createInstructor(instructor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Instructor>> listInstructors() {
        return InstructorsApi.super.listInstructors();
    }
}
