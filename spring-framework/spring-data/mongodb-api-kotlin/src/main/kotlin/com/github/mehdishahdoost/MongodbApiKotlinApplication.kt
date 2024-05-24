package com.github.mehdishahdoost

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongodbApiKotlinApplication

fun main(args: Array<String>) {
	runApplication<MongodbApiKotlinApplication>(*args)
}
