package com.richardevaristo.demoApp.Service;

import com.richardevaristo.demoApp.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Richard Evaristo", "Computer Science"),
            new Student(2, "John Doe", "Computer Engineering"),
            new Student(3, "Jane Smith", "Business Management")
    ));

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().get();
    }

    public void createStudent(Student student) {
        students.add(student);
    }

    public Student updateStudent(int id, Student student) {
        Student stud = this.getStudent(id);
        stud.setId(id);
        stud.setName(student.getName());
        stud.setCourse(student.getCourse());
        return stud;
    }

    public List<Student> deleteStudent(int id) {
        students.remove(this.getStudent(id));
        return students;
    }
}
