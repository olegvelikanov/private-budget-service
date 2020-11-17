package io.github.olegvelikanov.budgetservice

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.springframework.data.annotation.Id

@Serializable
data class Expense(
        @Id
        var id: Long,

        var amount: Int,

        var category: Category,

        @Serializable(with = AccountSerializer::class)
        var account: Account
)

object AccountSerializer : KSerializer<Account> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Account", PrimitiveKind.STRING)


    override fun serialize(encoder: Encoder, value: Account) {
        encoder.encodeLong(value.id)
    }

    override fun deserialize(decoder: Decoder): Account {
        val id = decoder.decodeLong()
        return Account(id)
    }
}



