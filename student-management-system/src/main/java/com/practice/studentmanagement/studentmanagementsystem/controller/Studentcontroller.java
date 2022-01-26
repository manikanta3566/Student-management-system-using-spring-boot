package com.practice.studentmanagement.studentmanagementsystem.controller;

import com.practice.studentmanagement.studentmanagementsystem.Entities.Student;
import com.practice.studentmanagement.studentmanagementsystem.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Studentcontroller {
    @Autowired
   private Services service;

    
    public Studentcontroller(Services service) {
        this.service = service;
    }


    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", this.service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudents(Model model){
        Student student=new Student();
        model.addAttribute("student", student);
        return "addstudents";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        this.service.addStudent(student);
     return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String updatePage(@PathVariable Long id,Model model){
model.addAttribute("student", this.service.getStudentById(id));
return "updatestudent";
    }
   @PostMapping("/students/{id}")
   public String update(@PathVariable Long id ,@ModelAttribute("student") Student student){
Student existingStudent=service.getStudentById(id);
existingStudent.setId(id);
existingStudent.setFirstname(student.getFirstname());
existingStudent.setLastname(student.getLastname());
existingStudent.setEmail(student.getEmail());
this.service.updateStudent(existingStudent);

return "redirect:/students";
   }

   @GetMapping("/students/{id}")
   public String deleteStudent(@PathVariable Long id){
   
      this.service.deleteStudentById(id);
       return "redirect:/students";
   }

}
