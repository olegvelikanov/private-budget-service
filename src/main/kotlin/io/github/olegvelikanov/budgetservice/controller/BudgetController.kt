package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.Expense
import io.github.olegvelikanov.budgetservice.service.AccountService
import io.github.olegvelikanov.budgetservice.service.ExpenseService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.builtins.list
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

    val logger: Logger = LoggerFactory.getLogger(BudgetController::class.java.simpleName)
    val json = Json(JsonConfiguration.Stable)

    @GetMapping("/getAllAccounts", produces = [APPLICATION_JSON_VALUE])
    fun getAccountsData(): String {
        return json.stringify(Account.serializer().list, accountService.getAllAccounts())
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
        return json.stringify(Expense.serializer().list, expenseService.getAllExpenses())
    }

//    @PostMapping("/addExpense", consumes = [APPLICATION_JSON_VALUE])
//    @ResponseStatus(OK)
//    fun addExpense(@RequestParam amount: Int, category: String, date: LocalDate) {
//        expenseService.addExpense(amount, category, date)
//    }

}
