package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.service.AccountService
import io.github.olegvelikanov.budgetservice.service.ExpenseService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class BudgetController(private val expenseService: ExpenseService, private val accountService: AccountService) {

    val log: Logger = LoggerFactory.getLogger(BudgetController::class.java.simpleName)

    @GetMapping("/getAllAccounts", produces = [APPLICATION_JSON_VALUE])
    fun getAccountsData(): String {
        return Json.encodeToString(accountService.getAllAccounts())
    }

    @PostMapping("/updateAccountBalanceById", consumes = [APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseStatus(OK)
    fun updateAccountAmount(@RequestParam id: Long, balance: Int) {
        accountService.updateAccountBalance(id, balance)
    }

    @PostMapping("/addAccount", consumes = [APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseStatus(OK)
    fun addAccount(@RequestParam balance: Int, type: String) {
        accountService.addAccount(balance, type)
    }

    @GetMapping("/getAllExpenses", produces = [APPLICATION_JSON_VALUE])
    fun getExpensesData(): String {
        return Json.encodeToString(expenseService.getAllExpenses())
    }

    @PostMapping("/addExpense", consumes = [APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseStatus(OK)
    fun addExpense(@RequestParam amount: Int, categoryId: Long, accountId: Long) {
        expenseService.addExpense(amount, categoryId, accountId)
    }

}
