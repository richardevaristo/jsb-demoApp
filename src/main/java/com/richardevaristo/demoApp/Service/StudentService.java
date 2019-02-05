package com.richardevaristo.demoApp.Service;

import com.richardevaristo.demoApp.Model.Student;
import com.richardevaristo.demoApp.Rest.StudentRest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private RestTemplate restTemplate;

    List<Student> students;

    private StudentRest rest;

    public List<Student> getAllStudents() {
        students = new ArrayList<>();
        rest = new StudentRest();
        students.addAll(rest.fetchStudents());
        return students;
    }

    public Student getStudent(int id) {
        return rest.fetchStudent(id);
//        return students.stream().filter(student -> student.getId() == id).findFirst().get();
    }

    public void createStudent(Student student) {
        students.add(rest.addStudent(student));
    }

    public Student updateStudent(int id, Student student) {
        return rest.editStudent(student, id);
    }

    public Student deleteStudent(int id) {
        return rest.deleteStudent(id);
    }
}
