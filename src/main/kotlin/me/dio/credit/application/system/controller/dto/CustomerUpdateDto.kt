package me.dio.credit.application.system.controller.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.model.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field:NotEmpty(message = "Invalid first name") val firstName: String,
    @field:NotEmpty(message = "Invalid last name") val lastName: String,
    @field:NotNull(message = "Invalid income") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid zipcode") val zipCode: String,
    @field:NotEmpty(message = "Invalid street") val street: String,
    @field:NotEmpty(message = "Invalid house number") val houseNumber: String,
    val complement: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        customer.address.houseNumber = this.houseNumber
        customer.address.complement = this.complement
        return customer
    }
}
