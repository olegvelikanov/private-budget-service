package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(val accountRepository: AccountRepository) {
    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll().toList()
    }
}