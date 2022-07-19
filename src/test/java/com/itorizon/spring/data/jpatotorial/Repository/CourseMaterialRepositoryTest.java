package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Course;
import com.itorizon.spring.data.jpatotorial.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course=Course.builder()
                .title("Java")
                .credit(10)
                .build();

        CourseMaterial courseMaterial=
                    CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

}