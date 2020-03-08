package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Expense
import io.github.olegvelikanov.budgetservice.persistence.repository.ExpenseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService(val expenseRepository: ExpenseRepository) {
    val logger: Logger = LoggerFactory.getLogger(ExpenseService::class.java.simpleName)

    fun getAllExpenses(): List<Expense> {
        return expenseRepository.findAll().map { Expense(it) }.toList()
    }

}