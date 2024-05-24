package com.github.mehdishahdoost.service

import com.github.mehdishahdoost.model.Student
import com.github.mehdishahdoost.repository.StudentRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService @Autowired constructor(
   private val studentRepository: StudentRepository
) {
   fun getStudent(): List<Student> = studentRepository.findAll();
}