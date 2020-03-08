package io.github.olegvelikanov.budgetservice.persistence.repository

import io.github.olegvelikanov.budgetservice.persistence.entity.ExpenseEntity
import org.springframework.data.repository.CrudRepository

interface ExpenseRepository : CrudRepository<ExpenseEntity, Long>
