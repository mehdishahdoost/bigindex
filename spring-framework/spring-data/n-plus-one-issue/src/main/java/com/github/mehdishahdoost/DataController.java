package com.github.mehdishahdoost;

import com.github.mehdishahdoost.model.Course;
import com.github.mehdishahdoost.model.Student;
import com.github.mehdishahdoost.repository.CourseRepository;
import com.github.mehdishahdoost.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
