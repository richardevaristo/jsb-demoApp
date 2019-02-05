package com.richardevaristo.demoApp.Rest;

import com.richardevaristo.demoApp.Model.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StudentRest {

    private RestTemplate restTemplate;

    public List<Student> fetchStudents() {
        restTemplate = new RestTemplate();
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                "http://localhost:3000/students",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {
                }
        );
        return response.getBody();
    }

    public Student fetchStudent(int id) {
        restTemplate = new RestTemplate();
        ResponseEntity<Student> response = restTemplate.exchange(
                "http://localhost:3000/students/" +id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Student>() {
                }
        );
        return response.getBody();
    }

    public Student addStudent(Student student) {
        restTemplate = new RestTemplate();
        
        HttpEntity<Student> s = new HttpEntity<>(student);
        ResponseEntity<Student> response = restTemplate.exchange(
                "http://localhost:3000/students",
                HttpMethod.POST,
                s,
                Student.class
        );
        return response.getBody();
    }

    public Student editStudent(Student student, int id) {
        restTemplate = new RestTemplate();
        HttpEntity<Student> student1 = new HttpEntity<>(student);
        ResponseEntity<Student> response = restTemplate.exchange(
                "http://localhost:3000/students/" + id,
                HttpMethod.PUT,
                student1,
                Student.class
        );
        return response.getBody();
    }

    public Student deleteStudent(int id) {
        restTemplate = new RestTemplate();
        ResponseEntity<Student> response = restTemplate.exchange(
                "http://localhost:3000/students/"+id,
                HttpMethod.DELETE,
                null,
                Student.class
        );
        return response.getBody();
    }

}
