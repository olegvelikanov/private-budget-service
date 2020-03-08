package io.github.olegvelikanov.budgetservice

import io.github.olegvelikanov.budgetservice.persistence.entity.AccountEntity
import kotlinx.serialization.Serializable

@Serializable
data class Account(var id: Long, var balance: Int, var accountType: String) {
    constructor(entity: AccountEntity) : this(entity.id, entity.balance, entity.accountType.type)
}