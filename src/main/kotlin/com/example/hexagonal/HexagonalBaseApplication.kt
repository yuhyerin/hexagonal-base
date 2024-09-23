package com.example.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HexagonalBaseApplication

fun main(args: Array<String>) {
    runApplication<HexagonalBaseApplication>(*args)
}
