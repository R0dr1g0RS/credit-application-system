package me.dio.credit.application.system.controller.dto

import me.dio.credit.application.system.model.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String,
    val houseNumber: String,
    val complement: String
) {

    constructor(customer: Customer): this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
        houseNumber = customer.address.houseNumber,
        complement = customer.address.complement
    )
}
