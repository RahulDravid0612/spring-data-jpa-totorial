package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Course;
import com.itorizon.spring.data.jpatotorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDS=Course.builder()
                .title("Data Structure")
                .credit(10)
                .build();

        Course courseML=Course.builder()
                .title("Machine Learning")
                .credit(10)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("chandan")
                .lastName("Hegde")
                .course(List.of(courseDS,courseML))
                .build();

        teacherRepository.save(teacher);
    }
}