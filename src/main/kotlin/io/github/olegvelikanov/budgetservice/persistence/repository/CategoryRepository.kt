package io.github.olegvelikanov.budgetservice.persistence.repository

import io.github.olegvelikanov.budgetservice.persistence.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {
    fun getOne(id: Long): Category
}
