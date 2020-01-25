package io.github.olegvelikanov.budgetservice.controller

import io.github.olegvelikanov.budgetservice.Account
import io.github.olegvelikanov.budgetservice.BudgetService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
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
import java.time.LocalDate

@RestController
class BudgetController(private val budgetService: BudgetService) {

    val logger: Logger = LoggerFactory.getLogger(BudgetController::class.java.simpleName)
    val json = Json(JsonConfiguration.Stable)

    @PostMapping("/addExpense", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(OK)
    fun addExpense(@RequestParam amount: Int, category: String, date: LocalDate) {
        budgetService.addExpense(amount, category, date)
    }

    @GetMapping("/getAccountsData", produces = [APPLICATION_JSON_VALUE])
    fun getAccountsData(): String {
        val data = budgetService.getAccountsData()
        val transformedData = mutableListOf<Account>()
        transformedData.addAll(data.values)
        logger.info("gave data")
        return json.stringify(Account.serializer().list, transformedData)
    }

    @PostMapping("/updateAccountAmount", consumes = [APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseStatus(OK)
    fun updateAccountAmount(@RequestParam id: Long, amount: Int) {
        budgetService.updateAccountAmount(id, amount)
    }

}