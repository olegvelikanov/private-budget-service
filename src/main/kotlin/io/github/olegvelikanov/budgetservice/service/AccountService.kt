package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.persistence.entity.AccountEntity
import io.github.olegvelikanov.budgetservice.persistence.entity.AccountTypeEntity
import io.github.olegvelikanov.budgetservice.persistence.repository.AccountRepository
import io.github.olegvelikanov.budgetservice.persistence.repository.AccountTypeRepository
import org.springframework.stereotype.Service

@Service
class AccountService(val accountRepository: AccountRepository, val accountTypeRepository: AccountTypeRepository) {
    private val accountsCache: HashMap<Long, Account> = hashMapOf()

    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll().map { Account(it) }.toList()
    }

    fun updateAccountBalance(id: Long, balance: Int) {
        val account = accountRepository.findById(id).orElseThrow { RuntimeException("No account with id=$id found") }
        account.balance = balance
        accountRepository.save(account)
    }

    fun addAccount(balance: Int, type: String) {
        val accountTypeOptional = accountTypeRepository.findByType(type)

        val accountType = accountTypeOptional.orElseGet {
            accountTypeRepository.save(AccountTypeEntity(0, type))
        }

        val account = AccountEntity(0, balance, accountType)
        accountRepository.save(account)
    }

}