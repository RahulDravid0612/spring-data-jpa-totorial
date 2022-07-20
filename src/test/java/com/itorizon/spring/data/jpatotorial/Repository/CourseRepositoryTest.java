package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Course;
import com.itorizon.spring.data.jpatotorial.Entity.CourseMaterial;
import com.itorizon.spring.data.jpatotorial.Entity.Student;
import com.itorizon.spring.data.jpatotorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.awt.print.PageFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("deeksha")
                .lastName("shetty")
                .build();

        Course course=Course.builder()
                .title("AOP")
                .credit(12)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithTreeRecords =
                PageRequest.of(0,3);
        Pageable firstPageWithTwoRecords =
                PageRequest.of(0,1);

        List<Course> courses=
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getContent();

        Long totalElement=
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getTotalElements();

        int totalPages=
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElement = " + totalElement);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle=PageRequest.of(
                1,
                2,
                Sort.by("title")
        );
        PageRequest sortByCredit=PageRequest.of(
                0,
                1,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDecs=PageRequest.of(
                0,
                1,
                Sort.by("title").descending().and(Sort.by("credit"))
        );

        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining(){

        Pageable firstPageTenRecords=
                PageRequest.of(0, 10);
        List<Course> courses=
                courseRepository.findByTitleContaining(
                "AO",
                firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
 public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("deepika")
                .lastName("D N")
                .build();

        Student student=Student.builder()
                .firstName("radee")
                .secondName("dranee")
                .emailId("radee@gmail.com")
                .build();
        Course course=Course.builder()
                .title("python")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
 }
}