package io.github.olegvelikanov.budgetservice.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "account")
data class AccountEntity(
    @Id @GeneratedValue var id: Long,
    var amount: Int,
    @ManyToOne var accountType: AccountTypeEntity
)

