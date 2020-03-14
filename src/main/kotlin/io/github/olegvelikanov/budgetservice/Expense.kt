package io.github.olegvelikanov.budgetservice

import io.github.olegvelikanov.budgetservice.persistence.entity.ExpenseEntity
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
//TODO: add expense date and category
data class Expense(
    var id: Long,
    var amount: Int,
    var accountId: Long
) {
    constructor(expense: ExpenseEntity) : this(expense.id, expense.amount, expense.account.id)
}
