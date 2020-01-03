package io.github.olegvelikanov.budgetservice

import kotlinx.serialization.Serializable

@Serializable
class Account(var amount: Int, val type: AccountType)