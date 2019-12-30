package io.github.olegvelikanov

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class TerminalApp

fun main(args: Array<String>) {
    SpringApplication.run(TerminalApp::class.java, *args)
}
