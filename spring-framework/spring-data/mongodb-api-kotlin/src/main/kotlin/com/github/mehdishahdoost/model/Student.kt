package com.github.mehdishahdoost.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Student(val firstName: String, val lastName: String, val gender: Gender, val address: Address, val email:String)