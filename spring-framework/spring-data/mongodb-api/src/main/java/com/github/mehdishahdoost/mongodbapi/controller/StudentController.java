package com.github.mehdishahdoost.mongodbapi.controller;


import com.github.mehdishahdoost.mongodbapi.model.Student;
import com.github.mehdishahdoost.mongodbapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return studentService.getStudents();
    }

}
