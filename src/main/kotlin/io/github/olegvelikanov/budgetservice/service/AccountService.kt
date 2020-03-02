package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(val accountRepository: AccountRepository) {
    private val accountsCache: HashMap<Long, Account> = hashMapOf()

    fun getAllAccounts(): MutableList<Account> {
        return accountRepository.findAll().map { Account(it) }.toMutableList()
    }

}