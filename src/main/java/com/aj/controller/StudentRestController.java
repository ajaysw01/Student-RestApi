package com.aj.controller;

import com.aj.entity.Student;
import com.aj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>("Student created with ID: " + createdStudent.getId(), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentData(@PathVariable("id") Long id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
