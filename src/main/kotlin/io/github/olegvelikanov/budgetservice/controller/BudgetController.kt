package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.BudgetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@ResponseStatus(HttpStatus.OK)
class GreetingController(private val budgetService: BudgetService) {

    @GetMapping("/addExpense")
    fun addExpense(@RequestParam amount: Int, category: String, date: LocalDate) {
        budgetService.addExpense(amount, category, date)
    }

}