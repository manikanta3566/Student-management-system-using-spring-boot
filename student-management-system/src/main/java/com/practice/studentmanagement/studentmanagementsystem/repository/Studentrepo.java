package com.practice.studentmanagement.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.studentmanagement.studentmanagementsystem.Entities.Student;
public interface Studentrepo extends JpaRepository<Student,Long>{
    
}
