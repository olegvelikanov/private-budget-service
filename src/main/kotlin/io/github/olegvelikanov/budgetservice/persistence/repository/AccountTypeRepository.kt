package io.github.olegvelikanov.budgetservice.persistence.repository

import io.github.olegvelikanov.budgetservice.persistence.entity.AccountTypeEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AccountTypeRepository : CrudRepository<AccountTypeEntity, Long> {
    fun findByType(type: String): Optional<AccountTypeEntity>
}