package io.github.olegvelikanov.budgetservice

import java.time.LocalDate

data class Expense(var id: Long, var amount: Int, var category: String, var date: LocalDate) {
}