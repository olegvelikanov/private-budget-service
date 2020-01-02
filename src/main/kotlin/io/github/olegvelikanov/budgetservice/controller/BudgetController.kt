package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.BudgetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
class BudgetController(private val budgetService: BudgetService) {

    @PostMapping("/addExpense", consumes = ["application/json"], produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun addExpense(@RequestParam amount: Int, category: String, date: LocalDate) {
        budgetService.addExpense(amount, category, date)
    }

    @GetMapping("/getAccountsData", consumes = ["application/json"], produces = ["application/json"])
    fun getAccountsData() {
        val data: HashMap<Long, Account> = budgetService.getAccountsData()

    }

}