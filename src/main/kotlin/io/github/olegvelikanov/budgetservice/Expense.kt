package io.github.olegvelikanov.budgetservice

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
data class Expense(
    var amount: Int,
    var category: String, @Serializable(with = LocalDateSerializer::class) var date: LocalDate
)

@Serializer(forClass = LocalDate::class)
object LocalDateSerializer : KSerializer<LocalDate> {
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