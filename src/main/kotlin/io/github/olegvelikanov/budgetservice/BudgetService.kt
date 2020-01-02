package io.github.olegvelikanov.budgetservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.concurrent.atomic.AtomicLong

@Service
class BudgetService {
    val logger: Logger = LoggerFactory.getLogger(BudgetService::class.java.simpleName)

    private val expensesIdBuilder = AtomicLong()
    private val expensesCache: HashMap<Long, Expense> = hashMapOf()

    private val accountsCache: HashMap<Long, Account> = hashMapOf(
        Pair(0L, Account(0, AccountType.DEBIT)),
        Pair(1L, Account(0, AccountType.CREDIT))
    )

    fun addExpense(amount: Int, category: String, date: LocalDate) {
        expensesCache[expensesIdBuilder.getAndIncrement()] = Expense(amount, category, date)
        logger.info("New expense added with amount: $amount in category: $category by date: $date")
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

    fun getAccountsData(): HashMap<Long, Account> {
        return accountsCache
    }
}