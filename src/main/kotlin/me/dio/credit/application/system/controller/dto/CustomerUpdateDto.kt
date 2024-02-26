package me.dio.credit.application.system.controller.dto

import me.dio.credit.application.system.model.Customer
import java.math.BigDecimal

data class CustomerUpdateDto (
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String,
    val houseNumber: String,
    val complement: String
) {

    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        customer.address.houseNumber = this.houseNumber
        customer.address.complement = this.complement
    }
}
