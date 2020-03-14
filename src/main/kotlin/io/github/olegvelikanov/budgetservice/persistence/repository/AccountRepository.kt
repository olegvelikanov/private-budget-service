package io.github.olegvelikanov.budgetservice.persistence.repository

import io.github.olegvelikanov.budgetservice.persistence.entity.AccountEntity
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<AccountEntity, Long> {
    fun getOne(id: Long): AccountEntity
}