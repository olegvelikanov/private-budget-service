package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.persistence.entity.Account
import io.github.olegvelikanov.budgetservice.persistence.entity.accountTypeFromString
import io.github.olegvelikanov.budgetservice.persistence.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(val accountRepository: AccountRepository) {
    private val accountsCache: HashMap<Long, Account> = hashMapOf()

    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll().toList()
    }

    fun updateAccountBalance(id: Long, balance: Int) {
        val account = accountRepository.findById(id).orElseThrow { RuntimeException("No account with id=$id found") }
        account.balance = balance
        accountRepository.save(account)
    }

    @Transactional
    fun addAccount(balance: Int, type: String) {
        val accountType = accountTypeFromString(type)

        val account = Account(0, balance, accountType)
        accountRepository.save(account)
    }

}