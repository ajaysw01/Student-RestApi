package com.aj.service;

import java.util.List;
import java.util.Optional;

import com.aj.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student studentDetails);

    boolean deleteStudent(Long id);
}
