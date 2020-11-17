package io.github.olegvelikanov.budgetservice

import kotlinx.serialization.Serializable
import org.springframework.data.annotation.Id

@Serializable
data class Category(
        @Id
        var id: Long,

        var category: String
)