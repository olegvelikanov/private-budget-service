package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Expense
import io.github.olegvelikanov.budgetservice.persistence.entity.AccountEntity
import io.github.olegvelikanov.budgetservice.persistence.entity.ExpenseEntity
import io.github.olegvelikanov.budgetservice.persistence.repository.AccountRepository
import io.github.olegvelikanov.budgetservice.persistence.repository.ExpenseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class ExpenseService(val expenseRepository: ExpenseRepository, val accountRepository: AccountRepository) {
    val logger: Logger = LoggerFactory.getLogger(ExpenseService::class.java.simpleName)

    fun getAllExpenses(): List<Expense> {
        return expenseRepository.findAll().map { Expense(it) }.toList()
    }

    fun addExpense(amount: Int, accountId: Long) {
        val account = accountRepository.getOne(accountId)

        val expense = ExpenseEntity(0, amount, account)
        expenseRepository.save(expense)
        throw RuntimeException()
    }

}