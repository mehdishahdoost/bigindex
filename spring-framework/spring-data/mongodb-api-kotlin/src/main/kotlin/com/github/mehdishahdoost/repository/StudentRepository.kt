package com.github.mehdishahdoost.repository

import com.github.mehdishahdoost.model.Student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<Student, String> {
    fun findByEmail(email: String): Student
}