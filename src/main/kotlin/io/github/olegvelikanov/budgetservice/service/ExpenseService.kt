package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.persistence.entity.Expense
import io.github.olegvelikanov.budgetservice.persistence.repository.AccountRepository
import io.github.olegvelikanov.budgetservice.persistence.repository.CategoryRepository
import io.github.olegvelikanov.budgetservice.persistence.repository.ExpenseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    val expenseRepository: ExpenseRepository,
    val categoryRepository: CategoryRepository,
    val accountRepository: AccountRepository
) {
    val logger: Logger = LoggerFactory.getLogger(ExpenseService::class.java.simpleName)

    fun getAllExpenses(): List<Expense> {
        return expenseRepository.findAll().toList()
    }

    fun addExpense(amount: Int, categoryId: Long, accountId: Long) {

        val category = categoryRepository.getOne(categoryId)
        val account = accountRepository.getOne(accountId)

        val expense = Expense(0, amount, category, account)
        expenseRepository.save(expense)
        throw RuntimeException()
    }

}