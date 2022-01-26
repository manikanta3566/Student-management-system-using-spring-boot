package com.practice.studentmanagement.studentmanagementsystem.service;

import java.util.List;

import com.practice.studentmanagement.studentmanagementsystem.Entities.Student;

public interface Services {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student s);
    Student updateStudent(Student s);
    void deleteStudentById(Long id);
}
