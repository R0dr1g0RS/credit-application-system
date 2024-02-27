package me.dio.credit.application.system.controller.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.model.Credit
import me.dio.credit.application.system.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    @field:NotNull(message = "Invalid credit value") val creditValue: BigDecimal,
    @field:Future(message = "Invalid date") val dayFirstOfInstallment: LocalDate,

    @Min(1, message = "The minimum number of installments is 1")
    @Max(48, message = "The maximum number of installments is 48")
    @field:NotNull(message = "Invalid number")
        val numberOfInstallments: Int,

    @NotNull(message = "Invalid customer ID") val customerId: Long
){
    fun toEntity(): Credit =
        Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstOfInstallment,
            numberOfInstalments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
        )
}
