package me.dio.credit.application.system.controller.dto

import me.dio.credit.application.system.model.Address
import me.dio.credit.application.system.model.Customer
import java.math.BigDecimal

data class CustomerDto (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
    val houseNumber: String,
    val complement: String
){


    fun toEntity(): Customer =
        Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            email = this.email,
            password = this.password,
            income = this.cpf,
            address = Address(
                zipCode = this.zipCode,
                street = this.street,
                houseNumber = this.houseNumber,
                complement = this.complement
            )

        )
}
