package com.richardevaristo.demoApp.Controller;


import com.richardevaristo.demoApp.Model.Student;
import com.richardevaristo.demoApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/students")
    public Student createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
}
