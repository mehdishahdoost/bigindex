package com.github.mehdishahdoost.controller

import com.github.mehdishahdoost.model.Student
import com.github.mehdishahdoost.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController @Autowired constructor(val studentService: StudentService) {

    @GetMapping("/students")
    fun getStudent(): List<Student> = studentService.getStudent()
}