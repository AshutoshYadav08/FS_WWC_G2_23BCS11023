package com.example.StudentMS.controller;
import com.example.StudentMS.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/students")
public class StudentController {


    private List<Student> students = new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
    

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {


        if(student.getName() == null || student.getCourse() == null || student.getName().isEmpty() || student.getCourse().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"name and course are required");
        }

        

        for (Student s : students){
            if (s.getId() == student.getId()){
                throw new ResponseStatusException(HttpStatus.CONFLICT,"student with the same ID already exists");
            }
        }
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Created Successfully");
    }



    // @GetMapping("/{id}")
    // public Student getStudent(@PathVariable int id) {
    //     for (Student s : students) {
    //         if (s.getId() == id) {
    //             return s;
    //         }
    //     }

    //     throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
    // }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return ResponseEntity.status(HttpStatus.OK).body(s);
                // return ResponseEntity.status(HttpStatus.OK).body("student found");
            }
        }
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found--");
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found--");
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return "Student deleted successfully";
            }
        }  

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
    }
    





}
