package io.github.olegvelikanov.budgetservice.persistence.entity

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Serializable
@Entity
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var amount: Int,

    @ManyToOne
    var category: Category,

    @Serializable(with = AccountSerializer::class)
    @ManyToOne
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



