package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.BudgetService
import kotlinx.serialization.internal.LongSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.map
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class BudgetController(private val budgetService: BudgetService) {

    val logger: Logger = LoggerFactory.getLogger(BudgetController::class.java.simpleName)
    val json = Json(JsonConfiguration.Stable)

    @PostMapping("/addExpense", produces = [APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun addExpense(@RequestParam amount: Int, category: String, date: LocalDate) {
        budgetService.addExpense(amount, category, date)
    }

    @GetMapping("/getAccountsData", produces = [APPLICATION_JSON_VALUE])
    fun getAccountsData(): String {
        val data: HashMap<Long, Account> = budgetService.getAccountsData()
        return json.stringify((LongSerializer to Account.serializer()).map, data)
    }

}