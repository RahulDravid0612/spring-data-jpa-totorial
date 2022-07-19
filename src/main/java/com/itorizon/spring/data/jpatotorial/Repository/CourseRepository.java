package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
