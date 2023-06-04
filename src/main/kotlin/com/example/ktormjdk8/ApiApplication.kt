package com.example.ktormjdk8

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.example.ktormjdk8")
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
