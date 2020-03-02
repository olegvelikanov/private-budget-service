package io.github.olegvelikanov.budgetservice

import io.github.olegvelikanov.budgetservice.entity.AccountEntity
import kotlinx.serialization.Serializable

@Serializable
data class Account(var id: Long, var amount: Int, var accountType: String) {
    constructor(entity: AccountEntity) : this(entity.id, entity.amount, entity.accountType.type)
}