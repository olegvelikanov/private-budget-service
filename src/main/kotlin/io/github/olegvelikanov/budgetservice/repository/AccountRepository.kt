package io.github.olegvelikanov.budgetservice.repository

import io.github.olegvelikanov.budgetservice.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface AccountRepository : CrudRepository<Account, Long>