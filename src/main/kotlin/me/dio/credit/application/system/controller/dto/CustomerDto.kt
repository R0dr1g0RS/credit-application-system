package me.dio.credit.application.system.controller.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.model.Address
import me.dio.credit.application.system.model.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto (
    @field:NotEmpty(message = "Invalid first name") val firstName: String,
    @field:NotEmpty(message = "Invalid last name") val lastName: String,
    @field:CPF(message = "Invalid CPF") val cpf: String,
    @field:NotNull(message = "Invalid income") val income: BigDecimal,
    @field:Email(message = "Invalid email") @field:NotEmpty(message = "Invalid email") val email: String,
    @field:NotEmpty(message = "Invalid password") val password: String,
    @field:NotEmpty(message = "Invalid zipcode") val zipCode: String,
    @field:NotEmpty(message = "Invalid street") val street: String,
    @field:NotEmpty(message = "Invalid house number") val houseNumber: String,
    val complement: String
){


    fun toEntity(): Customer =
        Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            email = this.email,
            password = this.password,
            income = this.income,
            address = Address(
                zipCode = this.zipCode,
                street = this.street,
                houseNumber = this.houseNumber,
                complement = this.complement
            )
        )
}
