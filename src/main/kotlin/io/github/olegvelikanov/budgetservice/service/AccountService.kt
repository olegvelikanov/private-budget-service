package io.github.olegvelikanov.budgetservice.service

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.entity.AccountEntity
import io.github.olegvelikanov.budgetservice.entity.AccountTypeEntity
import io.github.olegvelikanov.budgetservice.repository.AccountRepository
import io.github.olegvelikanov.budgetservice.repository.AccountTypeRepository
import org.springframework.stereotype.Service

@Service
class AccountService(val accountRepository: AccountRepository, val accountTypeRepository: AccountTypeRepository) {
    private val accountsCache: HashMap<Long, Account> = hashMapOf()

    fun getAllAccounts(): MutableList<Account> {
        return accountRepository.findAll().map { Account(it) }.toMutableList()
    }

    fun updateAccountAmount(id: Long, amount: Int) {
        val account = accountRepository.findById(id).orElseThrow { RuntimeException("No account with id=$id found") }
        account.amount = amount
        accountRepository.save(account)
    }

    fun addAccount(amount: Int, type: String) {
        val accountTypeOptional = accountTypeRepository.findByType(type)

        val accountType = accountTypeOptional.orElseGet {
            accountTypeRepository.save(AccountTypeEntity(0, type))
        }

        val account = AccountEntity(0, amount, accountType)
        accountRepository.save(account)
    }

}