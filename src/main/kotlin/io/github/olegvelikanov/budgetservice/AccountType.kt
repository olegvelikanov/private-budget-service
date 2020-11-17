package io.github.olegvelikanov.budgetservice

enum class AccountType(val type: String) {
    DBT("DBT"),
    CRD("CRD");

}

fun accountTypeFromString(type: String): AccountType {
    AccountType.values().forEach {
        if (type == it.type) {
            return it
        }
    }
    throw IllegalArgumentException("No such account type: $type")
}