package me.dio.credit.application.system.controller

import me.dio.credit.application.system.controller.dto.CustomerDto
import me.dio.credit.application.system.controller.dto.CustomerView
import me.dio.credit.application.system.model.Customer
import me.dio.credit.application.system.services.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/costumer")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable customerId: Long): CustomerView{
        val customer: Customer = this.customerService.findById(customerId)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable customerId: Long){
        this.customerService.delete(customerId)
    }
}