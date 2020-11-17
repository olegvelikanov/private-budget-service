package io.github.olegvelikanov.budgetservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class TerminalApp

fun main(args: Array<String>) {
    SpringApplication.run(TerminalApp::class.java, *args)
}
