package io.github.olegvelikanov.budgetservice.persistence.repository

import io.github.olegvelikanov.budgetservice.persistence.entity.Expense
import org.springframework.data.repository.CrudRepository

interface ExpenseRepository : CrudRepository<Expense, Long>
