package com.itorizon.spring.data.jpatotorial.Controller;

import com.itorizon.spring.data.jpatotorial.Entity.Student;
import com.itorizon.spring.data.jpatotorial.Exception.ResourceNotFoundException;
import com.itorizon.spring.data.jpatotorial.Exception.ResponseModel;
import com.itorizon.spring.data.jpatotorial.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> findByStudentId(@PathVariable Long studentId){
        Student student= studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student ID not found with id :"+studentId));
        return ResponseEntity.ok(student);
    }

@Pu

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> findByStudentId1(@PathVariable Long studentId) throws ResourceNotFoundException{

            if(studentRepository.findByStudentId(studentId) == null){
                throw new ResponseModel("Student ID not Found");
            }
            Student student = studentRepository.findByStudentId(studentId);

            return ResponseEntity.ok(student);
    }

    @GetMapping("/email/{emailId}")
    public String findNameByEmailId(@PathVariable String emailId){
        return studentRepository.getFirstNameStudentByEmailId(emailId);
    }
}
