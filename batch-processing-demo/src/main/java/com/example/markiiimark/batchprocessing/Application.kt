package com.example.markiiimark.batchprocessing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class Application {}

fun main(args: Array<out String>) {
  runApplication<Application>(*args)
}