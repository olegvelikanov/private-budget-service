package io.github.olegvelikanov.budgetservice

import java.time.LocalDate
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import java.time.format.DateTimeFormatter

@Serializable
data class Expense(var amount: Int, var category: String, @Serializable(with = LocalDateSerializer::class) var date: LocalDate) {
}

@Serializer(forClass = LocalDate::class)
object LocalDateSerializer: KSerializer<LocalDate> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    override val descriptor: SerialDescriptor =
        StringDescriptor.withName("WithCustomDefault")

    override fun serialize(encoder: Encoder, obj: LocalDate) {
        encoder.encodeString(obj.format(formatter))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString(), formatter)
    }
}