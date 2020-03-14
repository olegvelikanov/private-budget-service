package io.github.olegvelikanov.budgetservice.persistence.entity

import kotlinx.serialization.Serializable
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Serializable
@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var balance: Int?,

    @Enumerated(EnumType.STRING)
    var accountType: AccountType?
) {
    constructor(id: Long) : this(id, null, null)
}

