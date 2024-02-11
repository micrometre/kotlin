package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}
@RestController
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String) = "Helssslo, $name!"
}

