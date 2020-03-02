package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Expense
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ExpenseService {
    val logger: Logger = LoggerFactory.getLogger(ExpenseService::class.java.simpleName)

    private val expensesCache: HashMap<Long, Expense> = hashMapOf()

    fun addExpense() {

    }

    fun removeExpense(id: Long) {
        expensesCache.remove(id)
    }

    fun findExpensesInPeriod(from: LocalDate, to: LocalDate): HashMap<Long, Expense> {
        val result: HashMap<Long, Expense> = hashMapOf()
        expensesCache.forEach {
            if (it.value.date in from..to) {
                result[it.key] = it.value
            }
        }
        return result
    }

}