package com.practice.studentmanagement.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.practice.studentmanagement.studentmanagementsystem.Entities.Student;
import com.practice.studentmanagement.studentmanagementsystem.repository.Studentrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Studentserviceimpl implements Services{
    @Autowired
    Studentrepo repo;
    
    @Override
    public List<Student> getAllStudents() {
     return  repo.findAll();
    }

    @Override
    public Student addStudent(Student s) {
      return repo.save(s);
       
    }

    @Override
    public Student getStudentById(Long id) {
    return repo.findById(id).get();
    

    }

    @Override
    public Student updateStudent(Student student) {
  return repo.save(student);

        }

    @Override
    public void deleteStudentById(Long id) {
       repo.deleteById(id);
        
    }
}
