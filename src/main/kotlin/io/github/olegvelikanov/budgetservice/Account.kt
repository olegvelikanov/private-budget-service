package io.github.olegvelikanov.budgetservice

import kotlinx.serialization.Serializable

@Serializable
class Account(val id: Long, var amount: Int, val type: AccountType)