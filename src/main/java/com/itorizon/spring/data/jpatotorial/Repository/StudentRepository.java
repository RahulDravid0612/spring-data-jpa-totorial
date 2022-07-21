package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //JPA Method
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String Name);
    public List<Student> findByGuardianName(String Name);
    public List<Student> findBySecondName(String Name);
    public Student findByStudentId(Long studentId);

   //JPQL
    @Query("select s from Student s where s.emailId=?1")
     Student getStudentByEmailId(String emailId);
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getFirstNameStudentByEmailId(String emailId);


    //Native Query Method
    @Query(
            value = "SELECT * FROM tbl_student s where email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    //Native Query param
    @Query(
            value = "SELECT * FROM tbl_student s where email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
}

