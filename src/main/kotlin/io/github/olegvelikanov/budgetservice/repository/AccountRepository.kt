package io.github.olegvelikanov.budgetservice.repository

import io.github.olegvelikanov.budgetservice.entity.AccountEntity
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<AccountEntity, Long> {

}