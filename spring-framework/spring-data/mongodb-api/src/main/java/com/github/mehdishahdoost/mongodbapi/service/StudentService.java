package com.github.mehdishahdoost.mongodbapi.service;

import com.github.mehdishahdoost.mongodbapi.model.Student;
import com.github.mehdishahdoost.mongodbapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository  studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
