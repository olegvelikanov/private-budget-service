package io.github.olegvelikanov.budgetservice.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account_type")
class AccountTypeEntity(
    @Id @GeneratedValue var id: Long,
    var type: String
)