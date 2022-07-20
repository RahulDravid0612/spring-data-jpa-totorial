package com.itorizon.spring.data.jpatotorial.Repository;

import com.itorizon.spring.data.jpatotorial.Entity.Guardian;
import com.itorizon.spring.data.jpatotorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("dravid@gmail.com")
                .firstName("rahul")
                .secondName("dravid")
                //.guardianName("deepali")
               //.guardianEmail("deepali@gmail.com")
                //.guardianMobile("6764127721")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .name("rahul")
                .email("rahul@gmail.com")
                .mobile("2354253453")
                .build();

        Student student=Student.builder()
                .emailId("deepali@gmail.com")
                .firstName("deepali")
                .secondName("neethigere")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("deepali");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("de");
        System.out.println("students = " + students);
    }
    @Test
    public void printGuardianByGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("rahul");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentBysecondName(){
        List<Student> students=studentRepository.findBySecondName("dravid");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailId(){
        Student students=studentRepository.getStudentByEmailId("deepali@gmail.com");
        System.out.println("students = " + students);
    }
    @Test
    public void printFirstNameStudentByEmailId(){
        String firstName=studentRepository.getFirstNameStudentByEmailId("deepali@gmail.com");
        System.out.println("students = " + firstName);
    }
    @Test
    public void printStudentByEmailIdNative(){
        Student students=studentRepository.getStudentByEmailIdNative("deepali@gmail.com");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByEmailIdNativeParam(){
        Student students=studentRepository.getStudentByEmailIdNativeParam("deepali@gmail.com");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByEmailIdTest(){
       studentRepository.updateStudentNameByEmailId(
               "deepali",
               "deepali@gmail.com");

    }


}