package io.github.olegvelikanov.budgetservice.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService() {
    val logger: Logger = LoggerFactory.getLogger(ExpenseService::class.java.simpleName)
}