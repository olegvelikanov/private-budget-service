package io.github.olegvelikanov.budgetservice

import kotlinx.serialization.Serializable
import org.springframework.data.annotation.Id

@Serializable
data class Account(
        @Id
        var id: Long,

        var balance: Int?,

        var accountType: AccountType?
) {
    constructor(id: Long) : this(id, null, null)
}

